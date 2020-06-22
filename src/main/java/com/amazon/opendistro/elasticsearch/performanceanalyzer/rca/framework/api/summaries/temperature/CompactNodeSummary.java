/*
 * Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 *  A copy of the License is located at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  or in the "license" file accompanying this file. This file is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *  express or implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 */

package com.amazon.opendistro.elasticsearch.performanceanalyzer.rca.framework.api.summaries.temperature;

import com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.FlowUnitMessage;
import com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.NodeTemperatureSummaryMessage;
import com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.ResourceTemperatureMessage;
import com.amazon.opendistro.elasticsearch.performanceanalyzer.rca.framework.api.summaries.HotNodeSummary;
import com.amazon.opendistro.elasticsearch.performanceanalyzer.rca.framework.api.summaries.HotNodeSummary.SQL_SCHEMA_CONSTANTS;
import com.amazon.opendistro.elasticsearch.performanceanalyzer.rca.framework.core.GenericSummary;
import com.amazon.opendistro.elasticsearch.performanceanalyzer.rca.framework.core.temperature.TemperatureDimension;
import com.amazon.opendistro.elasticsearch.performanceanalyzer.rca.framework.core.temperature.TemperatureVector;
import com.amazon.opendistro.elasticsearch.performanceanalyzer.rca.framework.core.temperature.TemperatureVector.VectorValues;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.exception.DataTypeException;
import org.jooq.impl.DSL;

/**
 * This is created at two places - on each node and again on the cluster. On the node we have the
 * full resolution with dimensions and zones in each dimensions and then shards in zones. But on
 * the elected master we only have the temperature of a node and not zone or shard level
 * information. So, this summary is kept generic so that both can use it.
 */
public class CompactNodeSummary extends GenericSummary {

    private static final Logger LOG = LogManager.getLogger(CompactNodeSummary.class);
    /**
     * This will determine the name of the SQLite when this summary is persisted.
     */
    public static final String TABLE_NAME = CompactNodeSummary.class.getSimpleName();

    protected final String nodeId;
    protected final String hostAddress;

    protected TemperatureVector temperatureVector;

    /**
     * This is the actual usage. temperature vector is a normalized value and without the
     * context of total used, it means nothing.
     */
    protected double totalConsumedByDimension[];
    protected int numOfShards[];


    public static final String MEAN_SUFFIX_KEY = "_mean";
    public static final String TOTAL_SUFFIX_KEY = "_total";
    public static final String NUM_SHARDS_SUFFIX_KEY = "_num_shards";

    public CompactNodeSummary(final String nodeId, final String hostAddress) {
        super();
        this.nodeId = nodeId;
        this.hostAddress = hostAddress;
        this.temperatureVector = new TemperatureVector();
        this.totalConsumedByDimension = new double[TemperatureDimension.values().length];
        this.numOfShards = new int[TemperatureDimension.values().length];
    }

    public static CompactNodeSummary buildSummaryFromDatabase(Result<Record> records,
        DSLContext context) {
        if (records.size() != 1) {
            LOG.error("Expected 1 compact node summary, got {}. Summaries: {}", records.size(),
                records);
            throw new IllegalArgumentException(
                "Only 1 CompactNodeSummary expected. Found: " + records.size());
        }

        Record record = records.get(0);
        final String nodeId =
            record.get(DSL.field(DSL.name(HotNodeSummary.SQL_SCHEMA_CONSTANTS.NODE_ID_COL_NAME),
                String.class));
        final String hostAddress =
            record.get(DSL.field(DSL.name(SQL_SCHEMA_CONSTANTS.HOST_IP_ADDRESS_COL_NAME)), String.class);

        CompactNodeSummary summary = new CompactNodeSummary(nodeId, hostAddress);

        readAndSetNumShardsPerDimension(record, summary);
        readAndSetTemperatureVector(record, summary);

        return summary;
    }

    private static void readAndSetTemperatureVector(Record record, CompactNodeSummary summary) {
        try {
            for (TemperatureDimension dimension : TemperatureDimension.values()) {
                String normalizedMeanUsageForDimension = record
                    .get((DSL.field(DSL.name(dimension.NAME + MEAN_SUFFIX_KEY),
                        String.class)));
                short normalizedMeanUsageForDimensionValue = 0;
                String totalConsumedByDimension =
                        record.get(
                                (DSL.field(DSL.name(dimension.NAME + TOTAL_SUFFIX_KEY), String.class)));
                double totalConsumedByDimensionValue = 0;
                if (normalizedMeanUsageForDimension != null && !normalizedMeanUsageForDimension
                    .isEmpty()) {
                    normalizedMeanUsageForDimensionValue = Short.parseShort(normalizedMeanUsageForDimension);
                }
                if (totalConsumedByDimension != null && !totalConsumedByDimension.isEmpty()) {
                    totalConsumedByDimensionValue = Integer.parseInt(totalConsumedByDimension);
                }
                summary.setTemperatureForDimension(dimension,
                    new VectorValues(normalizedMeanUsageForDimensionValue, totalConsumedByDimensionValue));
            }
        } catch (final DataTypeException dte) {
            LOG.error("Couldn't convert to the right data type while reading temperature vector "
                + "from the DB. {}", dte.getMessage(), dte);
        }
    }

    private static void readAndSetNumShardsPerDimension(Record record, CompactNodeSummary summary) {
        try {
            for (TemperatureDimension dimension : TemperatureDimension.values()) {
                String numShardsForDimension = record
                    .get((DSL.field(DSL.name(dimension.NAME + NUM_SHARDS_SUFFIX_KEY),
                        String.class)));
                int value = 0;
                if (numShardsForDimension != null && !numShardsForDimension.isEmpty()) {
                    value = Integer.parseInt(numShardsForDimension);
                }
                summary.setNumOfShards(dimension, value);
            }
        } catch (final DataTypeException dte) {
            LOG.error("Couldn't convert to the right data type while reading num shards per"
                + " dimension from the DB. {}", dte.getMessage(), dte);
        }
    }

    public void fillFromNodeProfile(final FullNodeTemperatureSummary nodeProfile) {
        this.temperatureVector = nodeProfile.getTemperatureVector();
        this.totalConsumedByDimension = new double[TemperatureDimension.values().length];
        this.numOfShards = new int[TemperatureDimension.values().length];
        for (NodeLevelDimensionalSummary nodeDimensionProfile : nodeProfile.getNodeDimensionProfiles()) {
            if (nodeDimensionProfile != null) {
                int index = nodeDimensionProfile.getProfileForDimension().ordinal();
                totalConsumedByDimension[index] = nodeDimensionProfile.getTotalMetricValueUsed();
                numOfShards[index] = nodeDimensionProfile.getNumberOfShards();
            }
        }
    }

    public double getTotalConsumedByDimension(TemperatureDimension dimension) {
        return totalConsumedByDimension[dimension.ordinal()];
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setNumOfShards(TemperatureDimension dimension, int numOfShards) {
        this.numOfShards[dimension.ordinal()] = numOfShards;
    }

    public int getNumberOfShardsByDimension(TemperatureDimension dimension) {
        return numOfShards[dimension.ordinal()];
    }

    public void setTemperatureForDimension(TemperatureDimension dimension,
                                           VectorValues value) {
        temperatureVector.updateTemperatureForDimension(dimension, value);
    }

    public String getNodeId() {
        return nodeId;
    }

    public @Nullable
    VectorValues getTemperatureForDimension(TemperatureDimension dimension) {
        return temperatureVector.getTemperatureVectorValue(dimension);
    }

    @Override
    public NodeTemperatureSummaryMessage buildSummaryMessage() {
        if (totalConsumedByDimension == null) {
            throw new IllegalArgumentException("totalConsumedByDimension is not initialized");
        }

        final NodeTemperatureSummaryMessage.Builder summaryBuilder =
                NodeTemperatureSummaryMessage.newBuilder();
        summaryBuilder.setNodeID(nodeId);
        summaryBuilder.setHostAddress(hostAddress);


        for (TemperatureDimension dimension : TemperatureDimension.values()) {
            int index = dimension.ordinal();
            ResourceTemperatureMessage.Builder builder = ResourceTemperatureMessage.newBuilder();
            builder.setResourceName(dimension.NAME);
            VectorValues normalizedMean = temperatureVector.getTemperatureVectorValue(dimension);
            if (normalizedMean != null) {
                builder.setMeanUsage(normalizedMean.getHeatValue());
            } else {
                builder.setMeanUsage(0);
            }
            builder.setNumberOfShards(numOfShards[index]);
            builder.setTotalUsage(totalConsumedByDimension[index]);
            summaryBuilder.addCpuTemperature(index, builder);
        }
        return summaryBuilder.build();
    }

    @Override
    public void buildSummaryMessageAndAddToFlowUnit(FlowUnitMessage.Builder messageBuilder) {
        messageBuilder.setNodeTemperatureSummary(buildSummaryMessage());
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    public static CompactNodeSummary buildNodeTemperatureProfileFromMessage(NodeTemperatureSummaryMessage message) {
        CompactNodeSummary compactNodeTemperatureSummary =
                new CompactNodeSummary(message.getNodeID(), message.getHostAddress());

        compactNodeTemperatureSummary.totalConsumedByDimension = new double[TemperatureDimension.values().length];
        compactNodeTemperatureSummary.numOfShards = new int[TemperatureDimension.values().length];
        for (ResourceTemperatureMessage resourceMessage : message.getCpuTemperatureList()) {
            TemperatureDimension dimension =
                    TemperatureDimension.valueOf(resourceMessage.getResourceName());
            compactNodeTemperatureSummary.temperatureVector.updateTemperatureForDimension(dimension,
                    new VectorValues((short) resourceMessage.getMeanUsage(),0));
            compactNodeTemperatureSummary.totalConsumedByDimension[dimension.ordinal()] =
                    resourceMessage.getTotalUsage();
            compactNodeTemperatureSummary.numOfShards[dimension.ordinal()] =
                    resourceMessage.getNumberOfShards();
        }
        return compactNodeTemperatureSummary;
    }

    /**
     * @return Returns a list of columns that this table would contain.
     */
    @Override
    public List<Field<?>> getSqlSchema() {
        List<Field<?>> schema = new ArrayList<>();
        schema.add(DSL.field(DSL.name(HotNodeSummary.SQL_SCHEMA_CONSTANTS.NODE_ID_COL_NAME), String.class));
        schema.add(DSL.field(DSL.name(HotNodeSummary.SQL_SCHEMA_CONSTANTS.HOST_IP_ADDRESS_COL_NAME), String.class));

        for (TemperatureDimension dimension : TemperatureDimension.values()) {
            schema.add(DSL.field(DSL.name(dimension.NAME + MEAN_SUFFIX_KEY), String.class));
            schema.add(DSL.field(DSL.name(dimension.NAME + TOTAL_SUFFIX_KEY), String.class));
            schema.add(DSL.field(DSL.name(dimension.NAME + NUM_SHARDS_SUFFIX_KEY), String.class));
        }
        return schema;
    }

    @Override
    public List<Object> getSqlValue() {
        List<Object> value = new ArrayList<>();
        value.add(nodeId);
        value.add(hostAddress);

        for (TemperatureDimension dimension : TemperatureDimension.values()) {
            value.add(temperatureVector.getTemperatureVectorValue(dimension));
            value.add(totalConsumedByDimension[dimension.ordinal()]);
            value.add(numOfShards[dimension.ordinal()]);
        }
        return value;
    }

    @Override
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(HotNodeSummary.SQL_SCHEMA_CONSTANTS.NODE_ID_COL_NAME, nodeId);
        jsonObject.addProperty(HotNodeSummary.SQL_SCHEMA_CONSTANTS.HOST_IP_ADDRESS_COL_NAME, hostAddress);

        for (TemperatureDimension dimension : TemperatureDimension.values()) {
            VectorValues ret = temperatureVector.getTemperatureVectorValue(dimension);
            if (ret == null) {
                ret = new VectorValues((short) 0,0);
            }
            jsonObject.addProperty(dimension.NAME + MEAN_SUFFIX_KEY, ret.getHeatValue());
            jsonObject.addProperty(dimension.NAME + TOTAL_SUFFIX_KEY,
                    totalConsumedByDimension[dimension.ordinal()]);
            jsonObject.addProperty(dimension.NAME + NUM_SHARDS_SUFFIX_KEY, numOfShards[dimension.ordinal()]);
        }
        return jsonObject;
    }
}
