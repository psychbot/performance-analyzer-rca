// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: inter_node_rpc_service.proto

package com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc;

public interface ResourceTemperatureMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.ResourceTemperatureMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string resourceName = 1;</code>
   */
  java.lang.String getResourceName();
  /**
   * <code>string resourceName = 1;</code>
   */
  com.google.protobuf.ByteString
      getResourceNameBytes();

  /**
   * <pre>
   * The mean usage is the mean over all shards. There is also a shard independent component
   * that is accounted for in the hte totalUsage
   * </pre>
   *
   * <code>int32 meanUsage = 2;</code>
   */
  int getMeanUsage();

  /**
   * <code>int32 numberOfShards = 3;</code>
   */
  int getNumberOfShards();

  /**
   * <code>double totalUsage = 4;</code>
   */
  double getTotalUsage();
}