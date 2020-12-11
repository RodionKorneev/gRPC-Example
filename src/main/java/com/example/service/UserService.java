package com.example.service;

import com.example.grpc.ExampleProto.LoginRequest;
import com.example.grpc.ExampleProto.LoginResponse;
import com.example.grpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        //super.login(request, responseObserver);
        System.out.println(request);
        LoginResponse.Builder response = LoginResponse.newBuilder();
        if(request.getUsername() != null && !request.getUsername().isEmpty()){
            response.setResponseCode(0).setResponseMessage("success");
        } else
            response.setResponseCode(1).setResponseMessage("invalid username");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getMessages(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        System.out.println(request);
        LoginResponse.Builder response = LoginResponse.newBuilder();
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            response.setResponseCode(i).setResponseMessage("Message " + String.valueOf(i));
            responseObserver.onNext(response.build());
        }
        responseObserver.onCompleted();
    }
}
