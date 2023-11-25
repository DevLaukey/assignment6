package service;

import io.grpc.stub.StreamObserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.1)",
    comments = "Source: services/library.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LibraryGrpc {

  private LibraryGrpc() {}

  public static final String SERVICE_NAME = "services.Library";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.LibraryReq,
      service.LibraryRes> getCheckoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkout",
      requestType = service.LibraryReq.class,
      responseType = service.LibraryRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.LibraryReq,
      service.LibraryRes> getCheckoutMethod() {
    io.grpc.MethodDescriptor<service.LibraryReq, service.LibraryRes> getCheckoutMethod;
    if ((getCheckoutMethod = LibraryGrpc.getCheckoutMethod) == null) {
      synchronized (LibraryGrpc.class) {
        if ((getCheckoutMethod = LibraryGrpc.getCheckoutMethod) == null) {
          LibraryGrpc.getCheckoutMethod = getCheckoutMethod =
              io.grpc.MethodDescriptor.<service.LibraryReq, service.LibraryRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "checkout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.LibraryReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.LibraryRes.getDefaultInstance()))
              .setSchemaDescriptor(new LibraryMethodDescriptorSupplier("checkout"))
              .build();
        }
      }
    }
    return getCheckoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.LibraryReq,
      service.LibraryRes> getReturnBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "returnBook",
      requestType = service.LibraryReq.class,
      responseType = service.LibraryRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.LibraryReq,
      service.LibraryRes> getReturnBookMethod() {
    io.grpc.MethodDescriptor<service.LibraryReq, service.LibraryRes> getReturnBookMethod;
    if ((getReturnBookMethod = LibraryGrpc.getReturnBookMethod) == null) {
      synchronized (LibraryGrpc.class) {
        if ((getReturnBookMethod = LibraryGrpc.getReturnBookMethod) == null) {
          LibraryGrpc.getReturnBookMethod = getReturnBookMethod =
              io.grpc.MethodDescriptor.<service.LibraryReq, service.LibraryRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "returnBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.LibraryReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.LibraryRes.getDefaultInstance()))
              .setSchemaDescriptor(new LibraryMethodDescriptorSupplier("returnBook"))
              .build();
        }
      }
    }
    return getReturnBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      service.AvailableRes> getAvailableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "available",
      requestType = com.google.protobuf.Empty.class,
      responseType = service.AvailableRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      service.AvailableRes> getAvailableMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, service.AvailableRes> getAvailableMethod;
    if ((getAvailableMethod = LibraryGrpc.getAvailableMethod) == null) {
      synchronized (LibraryGrpc.class) {
        if ((getAvailableMethod = LibraryGrpc.getAvailableMethod) == null) {
          LibraryGrpc.getAvailableMethod = getAvailableMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, service.AvailableRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "available"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.AvailableRes.getDefaultInstance()))
              .setSchemaDescriptor(new LibraryMethodDescriptorSupplier("available"))
              .build();
        }
      }
    }
    return getAvailableMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LibraryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LibraryStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LibraryStub>() {
        @java.lang.Override
        public LibraryStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LibraryStub(channel, callOptions);
        }
      };
    return LibraryStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LibraryBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LibraryBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LibraryBlockingStub>() {
        @java.lang.Override
        public LibraryBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LibraryBlockingStub(channel, callOptions);
        }
      };
    return LibraryBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LibraryFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LibraryFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LibraryFutureStub>() {
        @java.lang.Override
        public LibraryFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LibraryFutureStub(channel, callOptions);
        }
      };
    return LibraryFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LibraryImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkout(service.LibraryReq request,
        io.grpc.stub.StreamObserver<service.LibraryRes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckoutMethod(), responseObserver);
    }

    /**
     */
    public void returnBook(service.LibraryReq request,
        io.grpc.stub.StreamObserver<service.LibraryRes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReturnBookMethod(), responseObserver);
    }

    /**
     */
    public void available(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<service.AvailableRes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAvailableMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckoutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.LibraryReq,
                service.LibraryRes>(
                  this, METHODID_CHECKOUT)))
          .addMethod(
            getReturnBookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.LibraryReq,
                service.LibraryRes>(
                  this, METHODID_RETURN_BOOK)))
          .addMethod(
            getAvailableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                service.AvailableRes>(
                  this, METHODID_AVAILABLE)))
          .build();
    }

      public abstract void available(google.protobuf.Empty request, StreamObserver<AvailableRes> responseObserver);
  }

  /**
   */
  public static final class LibraryStub extends io.grpc.stub.AbstractAsyncStub<LibraryStub> {
    private LibraryStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LibraryStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LibraryStub(channel, callOptions);
    }

    /**
     */
    public void checkout(service.LibraryReq request,
        io.grpc.stub.StreamObserver<service.LibraryRes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckoutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void returnBook(service.LibraryReq request,
        io.grpc.stub.StreamObserver<service.LibraryRes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReturnBookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void available(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<service.AvailableRes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAvailableMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LibraryBlockingStub extends io.grpc.stub.AbstractBlockingStub<LibraryBlockingStub> {
    private LibraryBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LibraryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LibraryBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.LibraryRes checkout(service.LibraryReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckoutMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.LibraryRes returnBook(service.LibraryReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReturnBookMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.AvailableRes available(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAvailableMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LibraryFutureStub extends io.grpc.stub.AbstractFutureStub<LibraryFutureStub> {
    private LibraryFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LibraryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LibraryFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.LibraryRes> checkout(
        service.LibraryReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckoutMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.LibraryRes> returnBook(
        service.LibraryReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReturnBookMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.AvailableRes> available(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAvailableMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECKOUT = 0;
  private static final int METHODID_RETURN_BOOK = 1;
  private static final int METHODID_AVAILABLE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LibraryImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LibraryImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECKOUT:
          serviceImpl.checkout((service.LibraryReq) request,
              (io.grpc.stub.StreamObserver<service.LibraryRes>) responseObserver);
          break;
        case METHODID_RETURN_BOOK:
          serviceImpl.returnBook((service.LibraryReq) request,
              (io.grpc.stub.StreamObserver<service.LibraryRes>) responseObserver);
          break;
        case METHODID_AVAILABLE:
          serviceImpl.available((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<service.AvailableRes>) responseObserver);
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

  private static abstract class LibraryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LibraryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.LibraryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Library");
    }
  }

  private static final class LibraryFileDescriptorSupplier
      extends LibraryBaseDescriptorSupplier {
    LibraryFileDescriptorSupplier() {}
  }

  private static final class LibraryMethodDescriptorSupplier
      extends LibraryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LibraryMethodDescriptorSupplier(String methodName) {
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
      synchronized (LibraryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LibraryFileDescriptorSupplier())
              .addMethod(getCheckoutMethod())
              .addMethod(getReturnBookMethod())
              .addMethod(getAvailableMethod())
              .build();
        }
      }
    }
    return result;
  }
}
