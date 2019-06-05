package com.atinbo.service;

import com.atinbo.HelloServiceImpl;
import io.grpc.netty.NettyServerBuilder;

public class Server {


    public static void main(String[] args) {
        io.grpc.Server server = null;
        try {
            server = NettyServerBuilder.forPort(9090).addService(new HelloServiceImpl()).build();
            server.start();
            server.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                server.shutdown();
            }
        }
    }
}
