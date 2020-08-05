package com.opendestro.kafkaAdapter.starter;

import com.opendestro.kafkaAdapter.configuration.ConsumerConfiguration;
import com.opendestro.kafkaAdapter.configuration.KafkaAdapterConf;
import com.opendestro.kafkaAdapter.util.KafkaAdapterConsts;
import com.opendestro.kafkaAdapter.util.Helper;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.Collections;


public class ConsumerStarter {
    private static final Logger LOG = LogManager.getLogger(ProducerStarter.class);
    public static void runConsumer(ConsumerConfiguration consumerConfig, int max_no_found, String webhooks_url) {
        int noMessageFound = 0;
        KafkaConsumer<String, JsonNode> consumer = consumerConfig.createConsumer();
        consumer.subscribe(Collections.singletonList(consumerConfig.getTopic()));
        try{
            while (true) {
                ConsumerRecords<String, JsonNode> consumerRecords = consumer.poll(Duration.ofMillis(consumerConfig.getInterval())); // setting seconds as waiting interval
                if (consumerRecords.count() == 0) {
                    noMessageFound++;
                    if (noMessageFound > max_no_found) { // if no response lasting 5 times, the consumer will terminate
                        System.out.println("No response, terminating");
                        break;
                    } else {
                        continue;
                    }
                }
                //print each record.
                consumerRecords.forEach(record -> {
                    Helper.postToSlackWebHook(record.value(), webhooks_url);
                });
                // commits the offset of record to broker.
                consumer.commitAsync();
            }
        } catch (WakeupException e){
            // ignore shutdown
        } finally {
            consumer.close();
            LOG.info("Shutting down the consumer");
        }
    }

    public static void startConsumer() {
        KafkaAdapterConf conf = new KafkaAdapterConf(KafkaAdapterConsts.KAFKA_ADAPTER_FILENAME);
        String bootstrapServer = conf.getKafkaBootstrapServer();
        String topic = conf.getKafkaTopicName();
        String webhooks_url = conf.getWebhooksUrl();
        long interval = conf.getReceivePeriodicityMillis();
        int max_no_found = conf.getMaxNoMessageFoundCountOnConsumer();
        ConsumerConfiguration consumerConfig = new ConsumerConfiguration(bootstrapServer, topic, interval);
        runConsumer(consumerConfig, max_no_found, webhooks_url);
    }
}