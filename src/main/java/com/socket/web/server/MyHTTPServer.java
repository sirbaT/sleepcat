package com.socket.web.server;

import com.socket.web.handler.SocketHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 我的Http服务器
 * Created by yaguang.wang
 * on 2017/4/5.
 */
public class MyHTTPServer {
    public static void main(String[] args) throws IOException {
        int port = 9090;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("启动服务，绑定端口：" + port);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(30);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("新的连接" + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
            try {
                fixedThreadPool.execute(new SocketHandler(clientSocket));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
