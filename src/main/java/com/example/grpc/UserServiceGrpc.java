package com.example.grpc;

import com.example.grpc.ExampleProto.LoginRequest;
import com.example.grpc.ExampleProto.LoginResponse;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import io.grpc.*;
import io.grpc.MethodDescriptor.MethodType;
import io.grpc.protobuf.ProtoFileDescriptorSupplier;
import io.grpc.protobuf.ProtoMethodDescriptorSupplier;
import io.grpc.protobuf.ProtoServiceDescriptorSupplier;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ServerCalls.*;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.annotations.RpcMethod;

import javax.annotation.Generated;

import static com.example.grpc.ExampleProto.getDescriptor;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.ServerServiceDefinition.builder;
import static io.grpc.protobuf.ProtoUtils.marshaller;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.*;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.*;

/**
 */
@Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: ExampleProto.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile MethodDescriptor<LoginRequest, LoginResponse> getLoginMethod;

  @RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = LoginRequest.class,
      responseType = LoginResponse.class,
      methodType = MethodType.UNARY)
  public static MethodDescriptor<LoginRequest, LoginResponse> getLoginMethod() {
    MethodDescriptor<LoginRequest, LoginResponse> getLoginMethod;
    if ((getLoginMethod = UserServiceGrpc.getLoginMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getLoginMethod = UserServiceGrpc.getLoginMethod) == null) {
          UserServiceGrpc.getLoginMethod = getLoginMethod = 
              MethodDescriptor.<LoginRequest, LoginResponse>newBuilder()
              .setType(MethodType.UNARY)
              .setFullMethodName(generateFullMethodName("UserService", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(marshaller(LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(marshaller(LoginResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("login"))
              .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile MethodDescriptor<LoginRequest, LoginResponse> getGetMessagesMethod;

  @RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMessages",
      requestType = LoginRequest.class,
      responseType = LoginResponse.class,
      methodType = MethodType.SERVER_STREAMING)
  public static MethodDescriptor<LoginRequest, LoginResponse> getGetMessagesMethod() {
    MethodDescriptor<LoginRequest, LoginResponse> getGetMessagesMethod;
    if ((getGetMessagesMethod = UserServiceGrpc.getGetMessagesMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetMessagesMethod = UserServiceGrpc.getGetMessagesMethod) == null) {
          UserServiceGrpc.getGetMessagesMethod = getGetMessagesMethod = 
              MethodDescriptor.<LoginRequest, LoginResponse>newBuilder()
              .setType(MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName("UserService", "getMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(marshaller(LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(marshaller(LoginResponse.getDefaultInstance()))
			  .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("getMessages"))
			  .build();
          }
        }
     }
     return getGetMessagesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(Channel channel) {
    return new UserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(Channel channel) {
    return new UserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(Channel channel) {
    return new UserServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements BindableService {

    /**
     */
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void getMessages(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMessagesMethod(), responseObserver);
    }

    @Override public final ServerServiceDefinition bindService() {
      return builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
            		new MethodHandlers<LoginRequest, LoginResponse>(this, METHODID_LOGIN)))
          .addMethod(
            getGetMessagesMethod(),
            asyncServerStreamingCall(
            		new MethodHandlers<LoginRequest, LoginResponse>(this, METHODID_GET_MESSAGES)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends AbstractStub<UserServiceStub> {
    private UserServiceStub(Channel channel) {
      super(channel);
    }

    private UserServiceStub(Channel channel, CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserServiceStub build(Channel channel, CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
      asyncUnaryCall(getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMessages(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetMessagesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends AbstractStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(Channel channel) {
      super(channel);
    }

    private UserServiceBlockingStub(Channel channel, CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserServiceBlockingStub build(Channel channel, CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public LoginResponse login(LoginRequest request) {
      return blockingUnaryCall(getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<LoginResponse> getMessages(LoginRequest request) {
      return blockingServerStreamingCall(getChannel(), getGetMessagesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
    private UserServiceFutureStub(Channel channel) {
      super(channel);
    }

    private UserServiceFutureStub(Channel channel, CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UserServiceFutureStub build(Channel channel, CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<LoginResponse> login(LoginRequest request) {
      return futureUnaryCall(getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_GET_MESSAGES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      UnaryMethod<Req, Resp>,
      ServerStreamingMethod<Req, Resp>,
      ClientStreamingMethod<Req, Resp>,
      BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((LoginRequest) request,
              (StreamObserver<LoginResponse>) responseObserver);
          break;
        case METHODID_GET_MESSAGES:
          serviceImpl.getMessages((LoginRequest) request,
              (StreamObserver<LoginResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @java.lang.SuppressWarnings("unchecked")
    public StreamObserver<Req> invoke(StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserServiceBaseDescriptorSupplier
      implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @Override
    public FileDescriptor getFileDescriptor() {
      return getDescriptor();
    }

    @Override
    public ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getGetMessagesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
