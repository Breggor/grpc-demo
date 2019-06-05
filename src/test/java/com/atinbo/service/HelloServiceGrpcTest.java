package com.atinbo.service;

import com.atinbo.HelloProtos;
import com.atinbo.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloServiceGrpcTest {
    ManagedChannel channel;
    HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;


    @Before
    public void init() {
        channel = ManagedChannelBuilder.forAddress("127.0.0.1", 9090).usePlaintext().build();
        helloServiceBlockingStub = HelloServiceGrpc.newBlockingStub(channel);
    }

    @After
    public void destroy() {
        channel.shutdown();
        helloServiceBlockingStub = null;
    }

    @Test
    public void testCall() {
        for (int i = 0; i < 10; i++) {
            HelloProtos.Request req = HelloProtos.Request.newBuilder().setNo(i).setParam("test_" + i).build();
            HelloProtos.Response res = helloServiceBlockingStub.doAct(req);
            System.out.println(res);
            Assert.assertEquals("返回参数不一致", req.toString(), res.getMesssage());
        }
    }

}