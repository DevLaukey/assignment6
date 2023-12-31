package service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.1)",
    comments = "Source: services/sort.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SortGrpc {

  private SortGrpc() {}

  public static final String SERVICE_NAME = "services.Sort";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.SortRequest,
      service.SortResponse> getSortMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sort",
      requestType = service.SortRequest.class,
      responseType = service.SortResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.SortRequest,
      service.SortResponse> getSortMethod() {
    io.grpc.MethodDescriptor<service.SortRequest, service.SortResponse> getSortMethod;
    if ((getSortMethod = SortGrpc.getSortMethod) == null) {
      synchronized (SortGrpc.class) {
        if ((getSortMethod = SortGrpc.getSortMethod) == null) {
          SortGrpc.getSortMethod = getSortMethod =
              io.grpc.MethodDescriptor.<service.SortRequest, service.SortResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sort"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.SortRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.SortResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SortMethodDescriptorSupplier("sort"))
              .build();
        }
      }
    }
    return getSortMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SortStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SortStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SortStub>() {
        @java.lang.Override
        public SortStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SortStub(channel, callOptions);
        }
      };
    return SortStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SortBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SortBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SortBlockingStub>() {
        @java.lang.Override
        public SortBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SortBlockingStub(channel, callOptions);
        }
      };
    return SortBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SortFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SortFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SortFutureStub>() {
        @java.lang.Override
        public SortFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SortFutureStub(channel, callOptions);
        }
      };
    return SortFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SortImplBase implements io.grpc.BindableService {

    /**
     */
    public void sort(service.SortRequest request,
        io.grpc.stub.StreamObserver<service.SortResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSortMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSortMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.SortRequest,
                service.SortResponse>(
                  this, METHODID_SORT)))
          .build();
    }
  }

  /**
   */
  public static final class SortStub extends io.grpc.stub.AbstractAsyncStub<SortStub> {
    private SortStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SortStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SortStub(channel, callOptions);
    }

    /**
     */
    public void sort(service.SortRequest request,
        io.grpc.stub.StreamObserver<service.SortResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSortMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SortBlockingStub extends io.grpc.stub.AbstractBlockingStub<SortBlockingStub> {
    private SortBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SortBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SortBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.SortResponse sort(service.SortRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSortMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SortFutureStub extends io.grpc.stub.AbstractFutureStub<SortFutureStub> {
    private SortFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SortFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SortFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.SortResponse> sort(
        service.SortRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSortMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SORT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SortImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SortImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SORT:
          serviceImpl.sort((service.SortRequest) request,
              (io.grpc.stub.StreamObserver<service.SortResponse>) responseObserver);
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

  private static abstract class SortBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SortBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.SortProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Sort");
    }
  }

  private static final class SortFileDescriptorSupplier
      extends SortBaseDescriptorSupplier {
    SortFileDescriptorSupplier() {}
  }

  private static final class SortMethodDescriptorSupplier
      extends SortBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SortMethodDescriptorSupplier(String methodName) {
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
      synchronized (SortGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SortFileDescriptorSupplier())
              .addMethod(getSortMethod())
              .build();
        }
      }
    }
    return result;
  }
}
