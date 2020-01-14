// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: inter_node_rpc_service.proto

package com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc;

/**
 * Protobuf type {@code com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList}
 */
public  final class HotNodeSummaryList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList)
    HotNodeSummaryListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use HotNodeSummaryList.newBuilder() to construct.
  private HotNodeSummaryList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HotNodeSummaryList() {
    hotNodeSummary_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private HotNodeSummaryList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              hotNodeSummary_ = new java.util.ArrayList<com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage>();
              mutable_bitField0_ |= 0x00000001;
            }
            hotNodeSummary_.add(
                input.readMessage(com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        hotNodeSummary_ = java.util.Collections.unmodifiableList(hotNodeSummary_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.PANetworking.internal_static_com_amazon_opendistro_elasticsearch_performanceanalyzer_grpc_HotNodeSummaryList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.PANetworking.internal_static_com_amazon_opendistro_elasticsearch_performanceanalyzer_grpc_HotNodeSummaryList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList.class, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList.Builder.class);
  }

  public static final int HOTNODESUMMARY_FIELD_NUMBER = 1;
  private java.util.List<com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage> hotNodeSummary_;
  /**
   * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
   */
  public java.util.List<com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage> getHotNodeSummaryList() {
    return hotNodeSummary_;
  }
  /**
   * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
   */
  public java.util.List<? extends com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessageOrBuilder> 
      getHotNodeSummaryOrBuilderList() {
    return hotNodeSummary_;
  }
  /**
   * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
   */
  public int getHotNodeSummaryCount() {
    return hotNodeSummary_.size();
  }
  /**
   * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
   */
  public com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage getHotNodeSummary(int index) {
    return hotNodeSummary_.get(index);
  }
  /**
   * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
   */
  public com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessageOrBuilder getHotNodeSummaryOrBuilder(
      int index) {
    return hotNodeSummary_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < hotNodeSummary_.size(); i++) {
      output.writeMessage(1, hotNodeSummary_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < hotNodeSummary_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, hotNodeSummary_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList)) {
      return super.equals(obj);
    }
    com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList other = (com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList) obj;

    if (!getHotNodeSummaryList()
        .equals(other.getHotNodeSummaryList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getHotNodeSummaryCount() > 0) {
      hash = (37 * hash) + HOTNODESUMMARY_FIELD_NUMBER;
      hash = (53 * hash) + getHotNodeSummaryList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList)
      com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.PANetworking.internal_static_com_amazon_opendistro_elasticsearch_performanceanalyzer_grpc_HotNodeSummaryList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.PANetworking.internal_static_com_amazon_opendistro_elasticsearch_performanceanalyzer_grpc_HotNodeSummaryList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList.class, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList.Builder.class);
    }

    // Construct using com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getHotNodeSummaryFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (hotNodeSummaryBuilder_ == null) {
        hotNodeSummary_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        hotNodeSummaryBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.PANetworking.internal_static_com_amazon_opendistro_elasticsearch_performanceanalyzer_grpc_HotNodeSummaryList_descriptor;
    }

    @java.lang.Override
    public com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList getDefaultInstanceForType() {
      return com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList.getDefaultInstance();
    }

    @java.lang.Override
    public com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList build() {
      com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList buildPartial() {
      com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList result = new com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList(this);
      int from_bitField0_ = bitField0_;
      if (hotNodeSummaryBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          hotNodeSummary_ = java.util.Collections.unmodifiableList(hotNodeSummary_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.hotNodeSummary_ = hotNodeSummary_;
      } else {
        result.hotNodeSummary_ = hotNodeSummaryBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList) {
        return mergeFrom((com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList other) {
      if (other == com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList.getDefaultInstance()) return this;
      if (hotNodeSummaryBuilder_ == null) {
        if (!other.hotNodeSummary_.isEmpty()) {
          if (hotNodeSummary_.isEmpty()) {
            hotNodeSummary_ = other.hotNodeSummary_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureHotNodeSummaryIsMutable();
            hotNodeSummary_.addAll(other.hotNodeSummary_);
          }
          onChanged();
        }
      } else {
        if (!other.hotNodeSummary_.isEmpty()) {
          if (hotNodeSummaryBuilder_.isEmpty()) {
            hotNodeSummaryBuilder_.dispose();
            hotNodeSummaryBuilder_ = null;
            hotNodeSummary_ = other.hotNodeSummary_;
            bitField0_ = (bitField0_ & ~0x00000001);
            hotNodeSummaryBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getHotNodeSummaryFieldBuilder() : null;
          } else {
            hotNodeSummaryBuilder_.addAllMessages(other.hotNodeSummary_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage> hotNodeSummary_ =
      java.util.Collections.emptyList();
    private void ensureHotNodeSummaryIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        hotNodeSummary_ = new java.util.ArrayList<com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage>(hotNodeSummary_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.Builder, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessageOrBuilder> hotNodeSummaryBuilder_;

    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public java.util.List<com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage> getHotNodeSummaryList() {
      if (hotNodeSummaryBuilder_ == null) {
        return java.util.Collections.unmodifiableList(hotNodeSummary_);
      } else {
        return hotNodeSummaryBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public int getHotNodeSummaryCount() {
      if (hotNodeSummaryBuilder_ == null) {
        return hotNodeSummary_.size();
      } else {
        return hotNodeSummaryBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage getHotNodeSummary(int index) {
      if (hotNodeSummaryBuilder_ == null) {
        return hotNodeSummary_.get(index);
      } else {
        return hotNodeSummaryBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public Builder setHotNodeSummary(
        int index, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage value) {
      if (hotNodeSummaryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureHotNodeSummaryIsMutable();
        hotNodeSummary_.set(index, value);
        onChanged();
      } else {
        hotNodeSummaryBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public Builder setHotNodeSummary(
        int index, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.Builder builderForValue) {
      if (hotNodeSummaryBuilder_ == null) {
        ensureHotNodeSummaryIsMutable();
        hotNodeSummary_.set(index, builderForValue.build());
        onChanged();
      } else {
        hotNodeSummaryBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public Builder addHotNodeSummary(com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage value) {
      if (hotNodeSummaryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureHotNodeSummaryIsMutable();
        hotNodeSummary_.add(value);
        onChanged();
      } else {
        hotNodeSummaryBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public Builder addHotNodeSummary(
        int index, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage value) {
      if (hotNodeSummaryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureHotNodeSummaryIsMutable();
        hotNodeSummary_.add(index, value);
        onChanged();
      } else {
        hotNodeSummaryBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public Builder addHotNodeSummary(
        com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.Builder builderForValue) {
      if (hotNodeSummaryBuilder_ == null) {
        ensureHotNodeSummaryIsMutable();
        hotNodeSummary_.add(builderForValue.build());
        onChanged();
      } else {
        hotNodeSummaryBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public Builder addHotNodeSummary(
        int index, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.Builder builderForValue) {
      if (hotNodeSummaryBuilder_ == null) {
        ensureHotNodeSummaryIsMutable();
        hotNodeSummary_.add(index, builderForValue.build());
        onChanged();
      } else {
        hotNodeSummaryBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public Builder addAllHotNodeSummary(
        java.lang.Iterable<? extends com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage> values) {
      if (hotNodeSummaryBuilder_ == null) {
        ensureHotNodeSummaryIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, hotNodeSummary_);
        onChanged();
      } else {
        hotNodeSummaryBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public Builder clearHotNodeSummary() {
      if (hotNodeSummaryBuilder_ == null) {
        hotNodeSummary_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        hotNodeSummaryBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public Builder removeHotNodeSummary(int index) {
      if (hotNodeSummaryBuilder_ == null) {
        ensureHotNodeSummaryIsMutable();
        hotNodeSummary_.remove(index);
        onChanged();
      } else {
        hotNodeSummaryBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.Builder getHotNodeSummaryBuilder(
        int index) {
      return getHotNodeSummaryFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessageOrBuilder getHotNodeSummaryOrBuilder(
        int index) {
      if (hotNodeSummaryBuilder_ == null) {
        return hotNodeSummary_.get(index);  } else {
        return hotNodeSummaryBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public java.util.List<? extends com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessageOrBuilder> 
         getHotNodeSummaryOrBuilderList() {
      if (hotNodeSummaryBuilder_ != null) {
        return hotNodeSummaryBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(hotNodeSummary_);
      }
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.Builder addHotNodeSummaryBuilder() {
      return getHotNodeSummaryFieldBuilder().addBuilder(
          com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.getDefaultInstance());
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.Builder addHotNodeSummaryBuilder(
        int index) {
      return getHotNodeSummaryFieldBuilder().addBuilder(
          index, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.getDefaultInstance());
    }
    /**
     * <code>repeated .com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage hotNodeSummary = 1;</code>
     */
    public java.util.List<com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.Builder> 
         getHotNodeSummaryBuilderList() {
      return getHotNodeSummaryFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.Builder, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessageOrBuilder> 
        getHotNodeSummaryFieldBuilder() {
      if (hotNodeSummaryBuilder_ == null) {
        hotNodeSummaryBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessage.Builder, com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryMessageOrBuilder>(
                hotNodeSummary_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        hotNodeSummary_ = null;
      }
      return hotNodeSummaryBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList)
  }

  // @@protoc_insertion_point(class_scope:com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList)
  private static final com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList();
  }

  public static com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<HotNodeSummaryList>
      PARSER = new com.google.protobuf.AbstractParser<HotNodeSummaryList>() {
    @java.lang.Override
    public HotNodeSummaryList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new HotNodeSummaryList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<HotNodeSummaryList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<HotNodeSummaryList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.amazon.opendistro.elasticsearch.performanceanalyzer.grpc.HotNodeSummaryList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

