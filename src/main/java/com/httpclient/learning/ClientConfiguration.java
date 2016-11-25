package com.httpclient.learning;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.conn.DefaultHttpResponseParser;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.util.CharArrayBuffer;

/**
 * This example demonstrates how to customize and configure the most common aspects
 * of HTTP request execution and connection management.
 * 此示例演示如何自定义和配置最常见的HTTP请求执行和连接管理。
 * Created by yaguang.wang on 2016/11/24.
 */
public class ClientConfiguration {
    public static void main(String[] args) {
        // 创建连接管理工厂 初始化成默认的Http 连接管理工厂
        HttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory() {
            @Override
            // 重写 生成工厂的方法
            public HttpMessageParser<HttpResponse> create(SessionInputBuffer buffer, MessageConstraints constraints) {
                LineParser lineParser = new BasicLineParser() {

                    @Override
                    public Header parseHeader(final CharArrayBuffer buffer) {
                        try {
                            return super.parseHeader(buffer);
                        } catch (ParseException ex) {
                            return new BasicHeader(buffer.toString(), null);
                        }
                    }
                };
                return new DefaultHttpResponseParser(buffer, lineParser, DefaultHttpResponseFactory.INSTANCE, constraints) {
                    @Override
                    protected boolean reject(final CharArrayBuffer line, int count) {
                        // try to ignore all garbage preceding a status line infinitely
                        // 尝试无限地忽略状态行之前的所有垃圾
                        return false;
                    }
                };
            }
        };
        // 写入器
        HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();

        // Use a custom connection factory to customize the process of
        // initialization of outgoing HTTP connections. Beside standard connection
        // configuration parameters HTTP connection factory can define message
        // parser / writer routines to be employed by individual connections.
        // 使用自定义连接工厂来定制初始化传出HTTP连接的过程。 除标准连接外配置参数HTTP连接工厂可以定义消息解析器写入器例程，供单个连接使用。
      /*  HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
                requestWriterFactory, responseParserFactory);
        HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
                requestWriterFactory, responseParserFactory);*/
        // Client HTTP connection objects when fully initialized can be bound to
        // an arbitrary network socket. The process of network socket initialization,
        // its connection to a remote address and binding to a local one is controlled
        // by a connection socket factory.
        // 客户端HTTP连接对象在完全初始化时可以绑定到任意网络套接字。 网络套接字初始化的过程，它的连接到远程地址和绑定到本地的过程由一个连接套接字工厂控制。
    }
}
