package services;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.1)",
    comments = "Source: services/trivia.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TriviaGameGrpc {

  private TriviaGameGrpc() {}

  public static final String SERVICE_NAME = "services.TriviaGame";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<services.Trivia.TriviaRequest,
      services.Trivia.TriviaResponse> getGetTriviaQuestionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTriviaQuestion",
      requestType = services.Trivia.TriviaRequest.class,
      responseType = services.Trivia.TriviaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<services.Trivia.TriviaRequest,
      services.Trivia.TriviaResponse> getGetTriviaQuestionMethod() {
    io.grpc.MethodDescriptor<services.Trivia.TriviaRequest, services.Trivia.TriviaResponse> getGetTriviaQuestionMethod;
    if ((getGetTriviaQuestionMethod = TriviaGameGrpc.getGetTriviaQuestionMethod) == null) {
      synchronized (TriviaGameGrpc.class) {
        if ((getGetTriviaQuestionMethod = TriviaGameGrpc.getGetTriviaQuestionMethod) == null) {
          TriviaGameGrpc.getGetTriviaQuestionMethod = getGetTriviaQuestionMethod =
              io.grpc.MethodDescriptor.<services.Trivia.TriviaRequest, services.Trivia.TriviaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getTriviaQuestion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.Trivia.TriviaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.Trivia.TriviaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TriviaGameMethodDescriptorSupplier("getTriviaQuestion"))
              .build();
        }
      }
    }
    return getGetTriviaQuestionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<services.Trivia.TriviaAnswerRequest,
      services.Trivia.TriviaAnswerResponse> getSubmitTriviaAnswerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "submitTriviaAnswer",
      requestType = services.Trivia.TriviaAnswerRequest.class,
      responseType = services.Trivia.TriviaAnswerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<services.Trivia.TriviaAnswerRequest,
      services.Trivia.TriviaAnswerResponse> getSubmitTriviaAnswerMethod() {
    io.grpc.MethodDescriptor<services.Trivia.TriviaAnswerRequest, services.Trivia.TriviaAnswerResponse> getSubmitTriviaAnswerMethod;
    if ((getSubmitTriviaAnswerMethod = TriviaGameGrpc.getSubmitTriviaAnswerMethod) == null) {
      synchronized (TriviaGameGrpc.class) {
        if ((getSubmitTriviaAnswerMethod = TriviaGameGrpc.getSubmitTriviaAnswerMethod) == null) {
          TriviaGameGrpc.getSubmitTriviaAnswerMethod = getSubmitTriviaAnswerMethod =
              io.grpc.MethodDescriptor.<services.Trivia.TriviaAnswerRequest, services.Trivia.TriviaAnswerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "submitTriviaAnswer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.Trivia.TriviaAnswerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.Trivia.TriviaAnswerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TriviaGameMethodDescriptorSupplier("submitTriviaAnswer"))
              .build();
        }
      }
    }
    return getSubmitTriviaAnswerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TriviaGameStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TriviaGameStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TriviaGameStub>() {
        @java.lang.Override
        public TriviaGameStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TriviaGameStub(channel, callOptions);
        }
      };
    return TriviaGameStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TriviaGameBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TriviaGameBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TriviaGameBlockingStub>() {
        @java.lang.Override
        public TriviaGameBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TriviaGameBlockingStub(channel, callOptions);
        }
      };
    return TriviaGameBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TriviaGameFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TriviaGameFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TriviaGameFutureStub>() {
        @java.lang.Override
        public TriviaGameFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TriviaGameFutureStub(channel, callOptions);
        }
      };
    return TriviaGameFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TriviaGameImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Request 1: Get a random trivia question
     * </pre>
     */
    public void getTriviaQuestion(services.Trivia.TriviaRequest request,
        io.grpc.stub.StreamObserver<services.Trivia.TriviaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTriviaQuestionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Request 2: Submit an answer to a trivia question
     * </pre>
     */
    public void submitTriviaAnswer(services.Trivia.TriviaAnswerRequest request,
        io.grpc.stub.StreamObserver<services.Trivia.TriviaAnswerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubmitTriviaAnswerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTriviaQuestionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                services.Trivia.TriviaRequest,
                services.Trivia.TriviaResponse>(
                  this, METHODID_GET_TRIVIA_QUESTION)))
          .addMethod(
            getSubmitTriviaAnswerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                services.Trivia.TriviaAnswerRequest,
                services.Trivia.TriviaAnswerResponse>(
                  this, METHODID_SUBMIT_TRIVIA_ANSWER)))
          .build();
    }
  }

  /**
   */
  public static final class TriviaGameStub extends io.grpc.stub.AbstractAsyncStub<TriviaGameStub> {
    private TriviaGameStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TriviaGameStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TriviaGameStub(channel, callOptions);
    }

    /**
     * <pre>
     * Request 1: Get a random trivia question
     * </pre>
     */
    public void getTriviaQuestion(services.Trivia.TriviaRequest request,
        io.grpc.stub.StreamObserver<services.Trivia.TriviaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTriviaQuestionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Request 2: Submit an answer to a trivia question
     * </pre>
     */
    public void submitTriviaAnswer(services.Trivia.TriviaAnswerRequest request,
        io.grpc.stub.StreamObserver<services.Trivia.TriviaAnswerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubmitTriviaAnswerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TriviaGameBlockingStub extends io.grpc.stub.AbstractBlockingStub<TriviaGameBlockingStub> {
    private TriviaGameBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TriviaGameBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TriviaGameBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Request 1: Get a random trivia question
     * </pre>
     */
    public services.Trivia.TriviaResponse getTriviaQuestion(services.Trivia.TriviaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTriviaQuestionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Request 2: Submit an answer to a trivia question
     * </pre>
     */
    public services.Trivia.TriviaAnswerResponse submitTriviaAnswer(services.Trivia.TriviaAnswerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitTriviaAnswerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TriviaGameFutureStub extends io.grpc.stub.AbstractFutureStub<TriviaGameFutureStub> {
    private TriviaGameFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TriviaGameFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TriviaGameFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Request 1: Get a random trivia question
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<services.Trivia.TriviaResponse> getTriviaQuestion(
        services.Trivia.TriviaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTriviaQuestionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Request 2: Submit an answer to a trivia question
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<services.Trivia.TriviaAnswerResponse> submitTriviaAnswer(
        services.Trivia.TriviaAnswerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubmitTriviaAnswerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TRIVIA_QUESTION = 0;
  private static final int METHODID_SUBMIT_TRIVIA_ANSWER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TriviaGameImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TriviaGameImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TRIVIA_QUESTION:
          serviceImpl.getTriviaQuestion((services.Trivia.TriviaRequest) request,
              (io.grpc.stub.StreamObserver<services.Trivia.TriviaResponse>) responseObserver);
          break;
        case METHODID_SUBMIT_TRIVIA_ANSWER:
          serviceImpl.submitTriviaAnswer((services.Trivia.TriviaAnswerRequest) request,
              (io.grpc.stub.StreamObserver<services.Trivia.TriviaAnswerResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TriviaGameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TriviaGameBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return services.Trivia.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TriviaGame");
    }
  }

  private static final class TriviaGameFileDescriptorSupplier
      extends TriviaGameBaseDescriptorSupplier {
    TriviaGameFileDescriptorSupplier() {}
  }

  private static final class TriviaGameMethodDescriptorSupplier
      extends TriviaGameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TriviaGameMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TriviaGameGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TriviaGameFileDescriptorSupplier())
              .addMethod(getGetTriviaQuestionMethod())
              .addMethod(getSubmitTriviaAnswerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
