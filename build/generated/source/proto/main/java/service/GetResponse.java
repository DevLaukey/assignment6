// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services/fitness.proto

package service;

/**
 * <pre>
 * Response from the server. Return a random exercise
 * if successful, otherwise a descriptive error message
 * </pre>
 *
 * Protobuf type {@code services.GetResponse}
 */
public final class GetResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:services.GetResponse)
    GetResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetResponse.newBuilder() to construct.
  private GetResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetResponse() {
    error_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetResponse(
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
          case 8: {

            isSuccess_ = input.readBool();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            error_ = s;
            break;
          }
          case 26: {
            service.Exercise.Builder subBuilder = null;
            if (exercise_ != null) {
              subBuilder = exercise_.toBuilder();
            }
            exercise_ = input.readMessage(service.Exercise.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(exercise_);
              exercise_ = subBuilder.buildPartial();
            }

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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return service.FitnessProto.internal_static_services_GetResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return service.FitnessProto.internal_static_services_GetResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            service.GetResponse.class, service.GetResponse.Builder.class);
  }

  public static final int ISSUCCESS_FIELD_NUMBER = 1;
  private boolean isSuccess_;
  /**
   * <code>bool isSuccess = 1;</code>
   * @return The isSuccess.
   */
  @java.lang.Override
  public boolean getIsSuccess() {
    return isSuccess_;
  }

  public static final int ERROR_FIELD_NUMBER = 2;
  private volatile java.lang.Object error_;
  /**
   * <code>string error = 2;</code>
   * @return The error.
   */
  @java.lang.Override
  public java.lang.String getError() {
    java.lang.Object ref = error_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      error_ = s;
      return s;
    }
  }
  /**
   * <code>string error = 2;</code>
   * @return The bytes for error.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getErrorBytes() {
    java.lang.Object ref = error_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      error_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int EXERCISE_FIELD_NUMBER = 3;
  private service.Exercise exercise_;
  /**
   * <code>.services.Exercise exercise = 3;</code>
   * @return Whether the exercise field is set.
   */
  @java.lang.Override
  public boolean hasExercise() {
    return exercise_ != null;
  }
  /**
   * <code>.services.Exercise exercise = 3;</code>
   * @return The exercise.
   */
  @java.lang.Override
  public service.Exercise getExercise() {
    return exercise_ == null ? service.Exercise.getDefaultInstance() : exercise_;
  }
  /**
   * <code>.services.Exercise exercise = 3;</code>
   */
  @java.lang.Override
  public service.ExerciseOrBuilder getExerciseOrBuilder() {
    return getExercise();
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
    if (isSuccess_ != false) {
      output.writeBool(1, isSuccess_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(error_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, error_);
    }
    if (exercise_ != null) {
      output.writeMessage(3, getExercise());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (isSuccess_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, isSuccess_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(error_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, error_);
    }
    if (exercise_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getExercise());
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
    if (!(obj instanceof service.GetResponse)) {
      return super.equals(obj);
    }
    service.GetResponse other = (service.GetResponse) obj;

    if (getIsSuccess()
        != other.getIsSuccess()) return false;
    if (!getError()
        .equals(other.getError())) return false;
    if (hasExercise() != other.hasExercise()) return false;
    if (hasExercise()) {
      if (!getExercise()
          .equals(other.getExercise())) return false;
    }
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
    hash = (37 * hash) + ISSUCCESS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsSuccess());
    hash = (37 * hash) + ERROR_FIELD_NUMBER;
    hash = (53 * hash) + getError().hashCode();
    if (hasExercise()) {
      hash = (37 * hash) + EXERCISE_FIELD_NUMBER;
      hash = (53 * hash) + getExercise().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static service.GetResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.GetResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.GetResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.GetResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.GetResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static service.GetResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static service.GetResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.GetResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.GetResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static service.GetResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static service.GetResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static service.GetResponse parseFrom(
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
  public static Builder newBuilder(service.GetResponse prototype) {
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
   * Response from the server. Return a random exercise
   * if successful, otherwise a descriptive error message
   * </pre>
   *
   * Protobuf type {@code services.GetResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:services.GetResponse)
      service.GetResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return service.FitnessProto.internal_static_services_GetResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return service.FitnessProto.internal_static_services_GetResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              service.GetResponse.class, service.GetResponse.Builder.class);
    }

    // Construct using service.GetResponse.newBuilder()
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
      isSuccess_ = false;

      error_ = "";

      if (exerciseBuilder_ == null) {
        exercise_ = null;
      } else {
        exercise_ = null;
        exerciseBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return service.FitnessProto.internal_static_services_GetResponse_descriptor;
    }

    @java.lang.Override
    public service.GetResponse getDefaultInstanceForType() {
      return service.GetResponse.getDefaultInstance();
    }

    @java.lang.Override
    public service.GetResponse build() {
      service.GetResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public service.GetResponse buildPartial() {
      service.GetResponse result = new service.GetResponse(this);
      result.isSuccess_ = isSuccess_;
      result.error_ = error_;
      if (exerciseBuilder_ == null) {
        result.exercise_ = exercise_;
      } else {
        result.exercise_ = exerciseBuilder_.build();
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
      if (other instanceof service.GetResponse) {
        return mergeFrom((service.GetResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(service.GetResponse other) {
      if (other == service.GetResponse.getDefaultInstance()) return this;
      if (other.getIsSuccess() != false) {
        setIsSuccess(other.getIsSuccess());
      }
      if (!other.getError().isEmpty()) {
        error_ = other.error_;
        onChanged();
      }
      if (other.hasExercise()) {
        mergeExercise(other.getExercise());
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
      service.GetResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (service.GetResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean isSuccess_ ;
    /**
     * <code>bool isSuccess = 1;</code>
     * @return The isSuccess.
     */
    @java.lang.Override
    public boolean getIsSuccess() {
      return isSuccess_;
    }
    /**
     * <code>bool isSuccess = 1;</code>
     * @param value The isSuccess to set.
     * @return This builder for chaining.
     */
    public Builder setIsSuccess(boolean value) {
      
      isSuccess_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isSuccess = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsSuccess() {
      
      isSuccess_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object error_ = "";
    /**
     * <code>string error = 2;</code>
     * @return The error.
     */
    public java.lang.String getError() {
      java.lang.Object ref = error_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        error_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string error = 2;</code>
     * @return The bytes for error.
     */
    public com.google.protobuf.ByteString
        getErrorBytes() {
      java.lang.Object ref = error_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        error_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string error = 2;</code>
     * @param value The error to set.
     * @return This builder for chaining.
     */
    public Builder setError(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      error_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string error = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearError() {
      
      error_ = getDefaultInstance().getError();
      onChanged();
      return this;
    }
    /**
     * <code>string error = 2;</code>
     * @param value The bytes for error to set.
     * @return This builder for chaining.
     */
    public Builder setErrorBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      error_ = value;
      onChanged();
      return this;
    }

    private service.Exercise exercise_;
    private com.google.protobuf.SingleFieldBuilderV3<
        service.Exercise, service.Exercise.Builder, service.ExerciseOrBuilder> exerciseBuilder_;
    /**
     * <code>.services.Exercise exercise = 3;</code>
     * @return Whether the exercise field is set.
     */
    public boolean hasExercise() {
      return exerciseBuilder_ != null || exercise_ != null;
    }
    /**
     * <code>.services.Exercise exercise = 3;</code>
     * @return The exercise.
     */
    public service.Exercise getExercise() {
      if (exerciseBuilder_ == null) {
        return exercise_ == null ? service.Exercise.getDefaultInstance() : exercise_;
      } else {
        return exerciseBuilder_.getMessage();
      }
    }
    /**
     * <code>.services.Exercise exercise = 3;</code>
     */
    public Builder setExercise(service.Exercise value) {
      if (exerciseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        exercise_ = value;
        onChanged();
      } else {
        exerciseBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.services.Exercise exercise = 3;</code>
     */
    public Builder setExercise(
        service.Exercise.Builder builderForValue) {
      if (exerciseBuilder_ == null) {
        exercise_ = builderForValue.build();
        onChanged();
      } else {
        exerciseBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.services.Exercise exercise = 3;</code>
     */
    public Builder mergeExercise(service.Exercise value) {
      if (exerciseBuilder_ == null) {
        if (exercise_ != null) {
          exercise_ =
            service.Exercise.newBuilder(exercise_).mergeFrom(value).buildPartial();
        } else {
          exercise_ = value;
        }
        onChanged();
      } else {
        exerciseBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.services.Exercise exercise = 3;</code>
     */
    public Builder clearExercise() {
      if (exerciseBuilder_ == null) {
        exercise_ = null;
        onChanged();
      } else {
        exercise_ = null;
        exerciseBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.services.Exercise exercise = 3;</code>
     */
    public service.Exercise.Builder getExerciseBuilder() {
      
      onChanged();
      return getExerciseFieldBuilder().getBuilder();
    }
    /**
     * <code>.services.Exercise exercise = 3;</code>
     */
    public service.ExerciseOrBuilder getExerciseOrBuilder() {
      if (exerciseBuilder_ != null) {
        return exerciseBuilder_.getMessageOrBuilder();
      } else {
        return exercise_ == null ?
            service.Exercise.getDefaultInstance() : exercise_;
      }
    }
    /**
     * <code>.services.Exercise exercise = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        service.Exercise, service.Exercise.Builder, service.ExerciseOrBuilder> 
        getExerciseFieldBuilder() {
      if (exerciseBuilder_ == null) {
        exerciseBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            service.Exercise, service.Exercise.Builder, service.ExerciseOrBuilder>(
                getExercise(),
                getParentForChildren(),
                isClean());
        exercise_ = null;
      }
      return exerciseBuilder_;
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


    // @@protoc_insertion_point(builder_scope:services.GetResponse)
  }

  // @@protoc_insertion_point(class_scope:services.GetResponse)
  private static final service.GetResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new service.GetResponse();
  }

  public static service.GetResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetResponse>() {
    @java.lang.Override
    public GetResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public service.GetResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

