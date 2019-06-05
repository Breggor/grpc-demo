package com.atinbo;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void doAct(HelloProtos.Request request, StreamObserver<HelloProtos.Response> responseObserver) {
        System.out.println(request.toString());
        HelloProtos.Response response = HelloProtos.Response.newBuilder().setStatus(1).setMesssage(request.toString()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
