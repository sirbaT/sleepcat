package com.socket.web.handler;

import java.io.*;
import java.net.Socket;

/**
 * 线程运行
 * Created by yaguang.wang
 * on 2017/4/5.
 */
public class SocketHandler implements Runnable {
    final static String CRLF = "\r\n";
    private Socket clientSocket;

    public SocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void handleSocket(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);
        String requestHeader = "";
        String s;
        while ((s = in.readLine()) != null) {
            s += CRLF;
            requestHeader = requestHeader + s;
            if (s.equals(CRLF)) {
                break;
            }
        }
        println("客户端请求头：");
        println(requestHeader);

        //String responseBody = "客户端的请求头是：\n" + requestHeader;
        String responseBody = "白雅靖么么哒";
        String responseHeader = "HTTP/1.0 200 OK\r\n" +
                "Content-Type: text/plain; charset=UTF-8\r\n" +
                "Content-Length: " + responseBody.getBytes().length + "\r\n" +
                "\r\n";

        println("响应头：");
        println(responseHeader);

        out.write(responseHeader);
        out.write(responseBody);
        out.flush();
        out.close();
        in.close();
        clientSocket.close();
    }

    private void println(String info) {
        System.out.println(info);
    }

    @Override
    public void run() {
        try {
            handleSocket(clientSocket);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
