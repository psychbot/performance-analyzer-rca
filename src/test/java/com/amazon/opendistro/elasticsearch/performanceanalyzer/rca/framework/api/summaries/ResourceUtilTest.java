package com.amazon.opendistro.elasticsearch.performanceanalyzer.rca.framework.api.summaries;

import com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.PANetworking;
import com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.Resource;
import com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.ResourceEnum;
import org.junit.Assert;
import org.junit.Test;

public class ResourceUtilTest {

    @Test
    public void testGetResourceTypeName() {
        Assert.assertEquals("old gen", ResourceUtil.getResourceTypeName(ResourceUtil.OLD_GEN_HEAP_USAGE));
        Assert.assertEquals("cpu usage", ResourceUtil.getResourceTypeName(ResourceUtil.CPU_USAGE));
    }

    @Test
    public void testGetResourceTypeUnit() {
        Assert.assertEquals("heap usage(memory usage in percentage)",
                ResourceUtil.getResourceTypeUnit(ResourceUtil.OLD_GEN_HEAP_USAGE));
        Assert.assertEquals("cpu usage(num of cores)",
                ResourceUtil.getResourceTypeUnit(ResourceUtil.CPU_USAGE));
    }

    @Test
    public void testBuildResourceType() {
        Resource oldGen = ResourceUtil.buildResourceType(0, 0);
        Assert.assertEquals(oldGen, ResourceUtil.OLD_GEN_HEAP_USAGE);
        Resource cpuResource = ResourceUtil.buildResourceType(2, 3);
        Assert.assertEquals(cpuResource, ResourceUtil.CPU_USAGE);
    }
}
