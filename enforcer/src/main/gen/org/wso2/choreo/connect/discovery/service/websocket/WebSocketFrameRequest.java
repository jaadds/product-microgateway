// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wso2/discovery/service/websocket/frame_service.proto

package org.wso2.choreo.connect.discovery.service.websocket;

/**
 * Protobuf type {@code envoy.extensions.filters.http.mgw_wasm_websocket.v3.WebSocketFrameRequest}
 */
public final class WebSocketFrameRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:envoy.extensions.filters.http.mgw_wasm_websocket.v3.WebSocketFrameRequest)
    WebSocketFrameRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WebSocketFrameRequest.newBuilder() to construct.
  private WebSocketFrameRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WebSocketFrameRequest() {
    nodeId_ = "";
    remoteIp_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new WebSocketFrameRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WebSocketFrameRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
            java.lang.String s = input.readStringRequireUtf8();

            nodeId_ = s;
            break;
          }
          case 18: {
            org.wso2.choreo.connect.discovery.service.websocket.Metadata.Builder subBuilder = null;
            if (metadata_ != null) {
              subBuilder = metadata_.toBuilder();
            }
            metadata_ = input.readMessage(org.wso2.choreo.connect.discovery.service.websocket.Metadata.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(metadata_);
              metadata_ = subBuilder.buildPartial();
            }

            break;
          }
          case 24: {

            frameLength_ = input.readInt32();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            remoteIp_ = s;
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.wso2.choreo.connect.discovery.service.websocket.MgwWebSocketProto.internal_static_envoy_extensions_filters_http_mgw_wasm_websocket_v3_WebSocketFrameRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.wso2.choreo.connect.discovery.service.websocket.MgwWebSocketProto.internal_static_envoy_extensions_filters_http_mgw_wasm_websocket_v3_WebSocketFrameRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest.class, org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest.Builder.class);
  }

  public static final int NODE_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object nodeId_;
  /**
   * <code>string node_id = 1;</code>
   * @return The nodeId.
   */
  @java.lang.Override
  public java.lang.String getNodeId() {
    java.lang.Object ref = nodeId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      nodeId_ = s;
      return s;
    }
  }
  /**
   * <code>string node_id = 1;</code>
   * @return The bytes for nodeId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNodeIdBytes() {
    java.lang.Object ref = nodeId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      nodeId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int METADATA_FIELD_NUMBER = 2;
  private org.wso2.choreo.connect.discovery.service.websocket.Metadata metadata_;
  /**
   * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
   * @return Whether the metadata field is set.
   */
  @java.lang.Override
  public boolean hasMetadata() {
    return metadata_ != null;
  }
  /**
   * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
   * @return The metadata.
   */
  @java.lang.Override
  public org.wso2.choreo.connect.discovery.service.websocket.Metadata getMetadata() {
    return metadata_ == null ? org.wso2.choreo.connect.discovery.service.websocket.Metadata.getDefaultInstance() : metadata_;
  }
  /**
   * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
   */
  @java.lang.Override
  public org.wso2.choreo.connect.discovery.service.websocket.MetadataOrBuilder getMetadataOrBuilder() {
    return getMetadata();
  }

  public static final int FRAME_LENGTH_FIELD_NUMBER = 3;
  private int frameLength_;
  /**
   * <code>int32 frame_length = 3;</code>
   * @return The frameLength.
   */
  @java.lang.Override
  public int getFrameLength() {
    return frameLength_;
  }

  public static final int REMOTE_IP_FIELD_NUMBER = 4;
  private volatile java.lang.Object remoteIp_;
  /**
   * <code>string remote_ip = 4;</code>
   * @return The remoteIp.
   */
  @java.lang.Override
  public java.lang.String getRemoteIp() {
    java.lang.Object ref = remoteIp_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      remoteIp_ = s;
      return s;
    }
  }
  /**
   * <code>string remote_ip = 4;</code>
   * @return The bytes for remoteIp.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getRemoteIpBytes() {
    java.lang.Object ref = remoteIp_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      remoteIp_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getNodeIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, nodeId_);
    }
    if (metadata_ != null) {
      output.writeMessage(2, getMetadata());
    }
    if (frameLength_ != 0) {
      output.writeInt32(3, frameLength_);
    }
    if (!getRemoteIpBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, remoteIp_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNodeIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, nodeId_);
    }
    if (metadata_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getMetadata());
    }
    if (frameLength_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, frameLength_);
    }
    if (!getRemoteIpBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, remoteIp_);
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
    if (!(obj instanceof org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest)) {
      return super.equals(obj);
    }
    org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest other = (org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest) obj;

    if (!getNodeId()
        .equals(other.getNodeId())) return false;
    if (hasMetadata() != other.hasMetadata()) return false;
    if (hasMetadata()) {
      if (!getMetadata()
          .equals(other.getMetadata())) return false;
    }
    if (getFrameLength()
        != other.getFrameLength()) return false;
    if (!getRemoteIp()
        .equals(other.getRemoteIp())) return false;
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
    hash = (37 * hash) + NODE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getNodeId().hashCode();
    if (hasMetadata()) {
      hash = (37 * hash) + METADATA_FIELD_NUMBER;
      hash = (53 * hash) + getMetadata().hashCode();
    }
    hash = (37 * hash) + FRAME_LENGTH_FIELD_NUMBER;
    hash = (53 * hash) + getFrameLength();
    hash = (37 * hash) + REMOTE_IP_FIELD_NUMBER;
    hash = (53 * hash) + getRemoteIp().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parseFrom(
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
  public static Builder newBuilder(org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest prototype) {
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
   * Protobuf type {@code envoy.extensions.filters.http.mgw_wasm_websocket.v3.WebSocketFrameRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:envoy.extensions.filters.http.mgw_wasm_websocket.v3.WebSocketFrameRequest)
      org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.wso2.choreo.connect.discovery.service.websocket.MgwWebSocketProto.internal_static_envoy_extensions_filters_http_mgw_wasm_websocket_v3_WebSocketFrameRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.wso2.choreo.connect.discovery.service.websocket.MgwWebSocketProto.internal_static_envoy_extensions_filters_http_mgw_wasm_websocket_v3_WebSocketFrameRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest.class, org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest.Builder.class);
    }

    // Construct using org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      nodeId_ = "";

      if (metadataBuilder_ == null) {
        metadata_ = null;
      } else {
        metadata_ = null;
        metadataBuilder_ = null;
      }
      frameLength_ = 0;

      remoteIp_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.wso2.choreo.connect.discovery.service.websocket.MgwWebSocketProto.internal_static_envoy_extensions_filters_http_mgw_wasm_websocket_v3_WebSocketFrameRequest_descriptor;
    }

    @java.lang.Override
    public org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest getDefaultInstanceForType() {
      return org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest build() {
      org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest buildPartial() {
      org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest result = new org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest(this);
      result.nodeId_ = nodeId_;
      if (metadataBuilder_ == null) {
        result.metadata_ = metadata_;
      } else {
        result.metadata_ = metadataBuilder_.build();
      }
      result.frameLength_ = frameLength_;
      result.remoteIp_ = remoteIp_;
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
      if (other instanceof org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest) {
        return mergeFrom((org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest other) {
      if (other == org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest.getDefaultInstance()) return this;
      if (!other.getNodeId().isEmpty()) {
        nodeId_ = other.nodeId_;
        onChanged();
      }
      if (other.hasMetadata()) {
        mergeMetadata(other.getMetadata());
      }
      if (other.getFrameLength() != 0) {
        setFrameLength(other.getFrameLength());
      }
      if (!other.getRemoteIp().isEmpty()) {
        remoteIp_ = other.remoteIp_;
        onChanged();
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
      org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object nodeId_ = "";
    /**
     * <code>string node_id = 1;</code>
     * @return The nodeId.
     */
    public java.lang.String getNodeId() {
      java.lang.Object ref = nodeId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nodeId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string node_id = 1;</code>
     * @return The bytes for nodeId.
     */
    public com.google.protobuf.ByteString
        getNodeIdBytes() {
      java.lang.Object ref = nodeId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nodeId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string node_id = 1;</code>
     * @param value The nodeId to set.
     * @return This builder for chaining.
     */
    public Builder setNodeId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      nodeId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string node_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearNodeId() {
      
      nodeId_ = getDefaultInstance().getNodeId();
      onChanged();
      return this;
    }
    /**
     * <code>string node_id = 1;</code>
     * @param value The bytes for nodeId to set.
     * @return This builder for chaining.
     */
    public Builder setNodeIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      nodeId_ = value;
      onChanged();
      return this;
    }

    private org.wso2.choreo.connect.discovery.service.websocket.Metadata metadata_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.wso2.choreo.connect.discovery.service.websocket.Metadata, org.wso2.choreo.connect.discovery.service.websocket.Metadata.Builder, org.wso2.choreo.connect.discovery.service.websocket.MetadataOrBuilder> metadataBuilder_;
    /**
     * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
     * @return Whether the metadata field is set.
     */
    public boolean hasMetadata() {
      return metadataBuilder_ != null || metadata_ != null;
    }
    /**
     * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
     * @return The metadata.
     */
    public org.wso2.choreo.connect.discovery.service.websocket.Metadata getMetadata() {
      if (metadataBuilder_ == null) {
        return metadata_ == null ? org.wso2.choreo.connect.discovery.service.websocket.Metadata.getDefaultInstance() : metadata_;
      } else {
        return metadataBuilder_.getMessage();
      }
    }
    /**
     * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
     */
    public Builder setMetadata(org.wso2.choreo.connect.discovery.service.websocket.Metadata value) {
      if (metadataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        metadata_ = value;
        onChanged();
      } else {
        metadataBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
     */
    public Builder setMetadata(
        org.wso2.choreo.connect.discovery.service.websocket.Metadata.Builder builderForValue) {
      if (metadataBuilder_ == null) {
        metadata_ = builderForValue.build();
        onChanged();
      } else {
        metadataBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
     */
    public Builder mergeMetadata(org.wso2.choreo.connect.discovery.service.websocket.Metadata value) {
      if (metadataBuilder_ == null) {
        if (metadata_ != null) {
          metadata_ =
            org.wso2.choreo.connect.discovery.service.websocket.Metadata.newBuilder(metadata_).mergeFrom(value).buildPartial();
        } else {
          metadata_ = value;
        }
        onChanged();
      } else {
        metadataBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
     */
    public Builder clearMetadata() {
      if (metadataBuilder_ == null) {
        metadata_ = null;
        onChanged();
      } else {
        metadata_ = null;
        metadataBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
     */
    public org.wso2.choreo.connect.discovery.service.websocket.Metadata.Builder getMetadataBuilder() {
      
      onChanged();
      return getMetadataFieldBuilder().getBuilder();
    }
    /**
     * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
     */
    public org.wso2.choreo.connect.discovery.service.websocket.MetadataOrBuilder getMetadataOrBuilder() {
      if (metadataBuilder_ != null) {
        return metadataBuilder_.getMessageOrBuilder();
      } else {
        return metadata_ == null ?
            org.wso2.choreo.connect.discovery.service.websocket.Metadata.getDefaultInstance() : metadata_;
      }
    }
    /**
     * <code>.envoy.extensions.filters.http.mgw_wasm_websocket.v3.Metadata metadata = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.wso2.choreo.connect.discovery.service.websocket.Metadata, org.wso2.choreo.connect.discovery.service.websocket.Metadata.Builder, org.wso2.choreo.connect.discovery.service.websocket.MetadataOrBuilder> 
        getMetadataFieldBuilder() {
      if (metadataBuilder_ == null) {
        metadataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.wso2.choreo.connect.discovery.service.websocket.Metadata, org.wso2.choreo.connect.discovery.service.websocket.Metadata.Builder, org.wso2.choreo.connect.discovery.service.websocket.MetadataOrBuilder>(
                getMetadata(),
                getParentForChildren(),
                isClean());
        metadata_ = null;
      }
      return metadataBuilder_;
    }

    private int frameLength_ ;
    /**
     * <code>int32 frame_length = 3;</code>
     * @return The frameLength.
     */
    @java.lang.Override
    public int getFrameLength() {
      return frameLength_;
    }
    /**
     * <code>int32 frame_length = 3;</code>
     * @param value The frameLength to set.
     * @return This builder for chaining.
     */
    public Builder setFrameLength(int value) {
      
      frameLength_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 frame_length = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearFrameLength() {
      
      frameLength_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object remoteIp_ = "";
    /**
     * <code>string remote_ip = 4;</code>
     * @return The remoteIp.
     */
    public java.lang.String getRemoteIp() {
      java.lang.Object ref = remoteIp_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        remoteIp_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string remote_ip = 4;</code>
     * @return The bytes for remoteIp.
     */
    public com.google.protobuf.ByteString
        getRemoteIpBytes() {
      java.lang.Object ref = remoteIp_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        remoteIp_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string remote_ip = 4;</code>
     * @param value The remoteIp to set.
     * @return This builder for chaining.
     */
    public Builder setRemoteIp(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      remoteIp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string remote_ip = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearRemoteIp() {
      
      remoteIp_ = getDefaultInstance().getRemoteIp();
      onChanged();
      return this;
    }
    /**
     * <code>string remote_ip = 4;</code>
     * @param value The bytes for remoteIp to set.
     * @return This builder for chaining.
     */
    public Builder setRemoteIpBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      remoteIp_ = value;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:envoy.extensions.filters.http.mgw_wasm_websocket.v3.WebSocketFrameRequest)
  }

  // @@protoc_insertion_point(class_scope:envoy.extensions.filters.http.mgw_wasm_websocket.v3.WebSocketFrameRequest)
  private static final org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest();
  }

  public static org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WebSocketFrameRequest>
      PARSER = new com.google.protobuf.AbstractParser<WebSocketFrameRequest>() {
    @java.lang.Override
    public WebSocketFrameRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WebSocketFrameRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WebSocketFrameRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WebSocketFrameRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.wso2.choreo.connect.discovery.service.websocket.WebSocketFrameRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

