// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: inter_node_rpc_service.proto

package com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc;

public interface ConsumersListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.ConsumersList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string consumer = 1;</code>
   */
  java.util.List<java.lang.String>
      getConsumerList();
  /**
   * <code>repeated string consumer = 1;</code>
   */
  int getConsumerCount();
  /**
   * <code>repeated string consumer = 1;</code>
   */
  java.lang.String getConsumer(int index);
  /**
   * <code>repeated string consumer = 1;</code>
   */
  com.google.protobuf.ByteString
      getConsumerBytes(int index);
}