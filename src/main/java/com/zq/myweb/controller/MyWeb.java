package com.zq.myweb.controller;

import com.zq.myweb.service.impl.HttpServer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: ZQ
 * @date: 2021-01-22-11:37
 */
public class MyWeb {

    public void startServer(int port) {
        try {
            @SuppressWarnings("resource")
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                new HttpServer(socket).start();

            }
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }


}
