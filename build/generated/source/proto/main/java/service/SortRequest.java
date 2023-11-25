// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/sort.proto

package service;

/**
 * <pre>
 * The request message includes an array of ints and a sorting algo
 * </pre>
 *
 * Protobuf type {@code services.SortRequest}
 */
public final class SortRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:services.SortRequest)
    SortRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SortRequest.newBuilder() to construct.
  private SortRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SortRequest() {
    algo_ = 0;
    data_ = emptyIntList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SortRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SortRequest(
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
          case 8: {
            int rawValue = input.readEnum();

            algo_ = rawValue;
            break;
          }
          case 16: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              data_ = newIntList();
              mutable_bitField0_ |= 0x00000001;
            }
            data_.addInt(input.readInt32());
            break;
          }
          case 18: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) != 0) && input.getBytesUntilLimit() > 0) {
              data_ = newIntList();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              data_.addInt(input.readInt32());
            }
            input.popLimit(limit);
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
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        data_.makeImmutable(); // C
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return service.SortProto.internal_static_services_SortRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return service.SortProto.internal_static_services_SortRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            service.SortRequest.class, service.SortRequest.Builder.class);
  }

  public static final int ALGO_FIELD_NUMBER = 1;
  private int algo_;
  /**
   * <code>.services.Algo algo = 1;</code>
   * @return The enum numeric value on the wire for algo.
   */
  @java.lang.Override public int getAlgoValue() {
    return algo_;
  }
  /**
   * <code>.services.Algo algo = 1;</code>
   * @return The algo.
   */
  @java.lang.Override public service.Algo getAlgo() {
    @SuppressWarnings("deprecation")
    service.Algo result = service.Algo.valueOf(algo_);
    return result == null ? service.Algo.UNRECOGNIZED : result;
  }

  public static final int DATA_FIELD_NUMBER = 2;
  private com.google.protobuf.Internal.IntList data_;
  /**
   * <pre>
   * represents the array to be sorted
   * </pre>
   *
   * <code>repeated int32 data = 2 [packed = true];</code>
   * @return A list containing the data.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
      getDataList() {
    return data_;
  }
  /**
   * <pre>
   * represents the array to be sorted
   * </pre>
   *
   * <code>repeated int32 data = 2 [packed = true];</code>
   * @return The count of data.
   */
  public int getDataCount() {
    return data_.size();
  }
  /**
   * <pre>
   * represents the array to be sorted
   * </pre>
   *
   * <code>repeated int32 data = 2 [packed = true];</code>
   * @param index The index of the element to return.
   * @return The data at the given index.
   */
  public int getData(int index) {
    return data_.getInt(index);
  }
  private int dataMemoizedSerializedSize = -1;

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
    getSerializedSize();
    if (algo_ != service.Algo.MERGE.getNumber()) {
      output.writeEnum(1, algo_);
    }
    if (getDataList().size() > 0) {
      output.writeUInt32NoTag(18);
      output.writeUInt32NoTag(dataMemoizedSerializedSize);
    }
    for (int i = 0; i < data_.size(); i++) {
      output.writeInt32NoTag(data_.getInt(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (algo_ != service.Algo.MERGE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, algo_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < data_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(data_.getInt(i));
      }
      size += dataSize;
      if (!getDataList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      dataMemoizedSerializedSize = dataSize;
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
    if (!(obj instanceof service.SortRequest)) {
      return super.equals(obj);
    }
    service.SortRequest other = (service.SortRequest) obj;

    if (algo_ != other.algo_) return false;
    if (!getDataList()
        .equals(other.getDataList())) return false;
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
    hash = (37 * hash) + ALGO_FIELD_NUMBER;
    hash = (53 * hash) + algo_;
    if (getDataCount() > 0) {
      hash = (37 * hash) + DATA_FIELD_NUMBER;
      hash = (53 * hash) + getDataList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static service.SortRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.SortRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.SortRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.SortRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.SortRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.SortRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.SortRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.SortRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.SortRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static service.SortRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.SortRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.SortRequest parseFrom(
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
  public static Builder newBuilder(service.SortRequest prototype) {
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
   * <pre>
   * The request message includes an array of ints and a sorting algo
   * </pre>
   *
   * Protobuf type {@code services.SortRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:services.SortRequest)
      service.SortRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return service.SortProto.internal_static_services_SortRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return service.SortProto.internal_static_services_SortRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              service.SortRequest.class, service.SortRequest.Builder.class);
    }

    // Construct using service.SortRequest.newBuilder()
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
      algo_ = 0;

      data_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return service.SortProto.internal_static_services_SortRequest_descriptor;
    }

    @java.lang.Override
    public service.SortRequest getDefaultInstanceForType() {
      return service.SortRequest.getDefaultInstance();
    }

    @java.lang.Override
    public service.SortRequest build() {
      service.SortRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public service.SortRequest buildPartial() {
      service.SortRequest result = new service.SortRequest(this);
      int from_bitField0_ = bitField0_;
      result.algo_ = algo_;
      if (((bitField0_ & 0x00000001) != 0)) {
        data_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.data_ = data_;
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
      if (other instanceof service.SortRequest) {
        return mergeFrom((service.SortRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(service.SortRequest other) {
      if (other == service.SortRequest.getDefaultInstance()) return this;
      if (other.algo_ != 0) {
        setAlgoValue(other.getAlgoValue());
      }
      if (!other.data_.isEmpty()) {
        if (data_.isEmpty()) {
          data_ = other.data_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureDataIsMutable();
          data_.addAll(other.data_);
        }
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
      service.SortRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (service.SortRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int algo_ = 0;
    /**
     * <code>.services.Algo algo = 1;</code>
     * @return The enum numeric value on the wire for algo.
     */
    @java.lang.Override public int getAlgoValue() {
      return algo_;
    }
    /**
     * <code>.services.Algo algo = 1;</code>
     * @param value The enum numeric value on the wire for algo to set.
     * @return This builder for chaining.
     */
    public Builder setAlgoValue(int value) {
      
      algo_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.services.Algo algo = 1;</code>
     * @return The algo.
     */
    @java.lang.Override
    public service.Algo getAlgo() {
      @SuppressWarnings("deprecation")
      service.Algo result = service.Algo.valueOf(algo_);
      return result == null ? service.Algo.UNRECOGNIZED : result;
    }
    /**
     * <code>.services.Algo algo = 1;</code>
     * @param value The algo to set.
     * @return This builder for chaining.
     */
    public Builder setAlgo(service.Algo value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      algo_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.services.Algo algo = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearAlgo() {
      
      algo_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.Internal.IntList data_ = emptyIntList();
    private void ensureDataIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        data_ = mutableCopy(data_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     * represents the array to be sorted
     * </pre>
     *
     * <code>repeated int32 data = 2 [packed = true];</code>
     * @return A list containing the data.
     */
    public java.util.List<java.lang.Integer>
        getDataList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(data_) : data_;
    }
    /**
     * <pre>
     * represents the array to be sorted
     * </pre>
     *
     * <code>repeated int32 data = 2 [packed = true];</code>
     * @return The count of data.
     */
    public int getDataCount() {
      return data_.size();
    }
    /**
     * <pre>
     * represents the array to be sorted
     * </pre>
     *
     * <code>repeated int32 data = 2 [packed = true];</code>
     * @param index The index of the element to return.
     * @return The data at the given index.
     */
    public int getData(int index) {
      return data_.getInt(index);
    }
    /**
     * <pre>
     * represents the array to be sorted
     * </pre>
     *
     * <code>repeated int32 data = 2 [packed = true];</code>
     * @param index The index to set the value at.
     * @param value The data to set.
     * @return This builder for chaining.
     */
    public Builder setData(
        int index, int value) {
      ensureDataIsMutable();
      data_.setInt(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * represents the array to be sorted
     * </pre>
     *
     * <code>repeated int32 data = 2 [packed = true];</code>
     * @param value The data to add.
     * @return This builder for chaining.
     */
    public Builder addData(int value) {
      ensureDataIsMutable();
      data_.addInt(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * represents the array to be sorted
     * </pre>
     *
     * <code>repeated int32 data = 2 [packed = true];</code>
     * @param values The data to add.
     * @return This builder for chaining.
     */
    public Builder addAllData(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureDataIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, data_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * represents the array to be sorted
     * </pre>
     *
     * <code>repeated int32 data = 2 [packed = true];</code>
     * @return This builder for chaining.
     */
    public Builder clearData() {
      data_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
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


    // @@protoc_insertion_point(builder_scope:services.SortRequest)
  }

  // @@protoc_insertion_point(class_scope:services.SortRequest)
  private static final service.SortRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new service.SortRequest();
  }

  public static service.SortRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SortRequest>
      PARSER = new com.google.protobuf.AbstractParser<SortRequest>() {
    @java.lang.Override
    public SortRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SortRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SortRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SortRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public service.SortRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

