package com.httpclient.learning;

import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.*;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.*;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/**
 * This example demonstrates how to customize and configure the most common aspects
 * of HTTP request execution and connection management.
 * 此示例演示如何自定义和配置最常见的HTTP请求执行和连接管理。
 * Created by yaguang.wang on 2016/11/24.
 */
public class ClientConfiguration {
    public static void main(String[] args) throws IOException {
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
        HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
                requestWriterFactory, responseParserFactory);
        // Client HTTP connection objects when fully initialized can be bound to
        // an arbitrary network socket. The process of network socket initialization,
        // its connection to a remote address and binding to a local one is controlled
        // by a connection socket factory.
        // 客户端HTTP连接对象在完全初始化时可以绑定到任意网络套接字。 网络套接字初始化的过程，它的连接到远程地址和绑定到本地的过程由一个连接套接字工厂控制。

        // SSL context for secure connections can be created either based on
        // system or application specific properties.
        // 可以基于系统或应用程序特定属性创建安全连接的SSL上下文
        SSLContext sslContext = SSLContexts.createSystemDefault();

        // Create a registry of custom connection socket factories for supported
        // protocol schemes.

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslContext))
                .build();
        // Use custom DNS resolver to override the system DNS resolution.

        DnsResolver dnsResolver = new SystemDefaultDnsResolver() {
            public InetAddress[] resolve(final String host) throws UnknownHostException {
                if (host.equalsIgnoreCase("myhost")) {
                    return new InetAddress[]{InetAddress.getByAddress(new byte[]{127, 0, 0, 1})};
                } else {
                    return super.resolve(host);
                }
            }
        };
        // Create a connection manager with custom configuration
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry, connFactory, dnsResolver);

        // Create a socket configuration
        SocketConfig socketConfig = SocketConfig.custom()
                .setTcpNoDelay(true)
                .build();
        // Configure the connection manager to use socket configuration either
        // by default or for a specific host
        connManager.setDefaultSocketConfig(socketConfig);
        connManager.setSocketConfig(new HttpHost("someHost", 80), socketConfig);
        //Validate connections after 1 sec of inactivity
        connManager.setValidateAfterInactivity(1000);

        // Create message constraints
        MessageConstraints messageConstraints = MessageConstraints.custom()
                .setMaxHeaderCount(200)
                .setMaxLineLength(2000)
                .build();
        // Create message constraints
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setMalformedInputAction(CodingErrorAction.IGNORE)
                .setUnmappableInputAction(CodingErrorAction.IGNORE)
                .setCharset(Consts.UTF_8)
                .setMessageConstraints(messageConstraints)
                .build();
        // Configure the connection manager to use connection configuration either
        // by default or for a specific host.
        connManager.setDefaultConnectionConfig(connectionConfig);
        connManager.setConnectionConfig(new HttpHost("somehost", 80), ConnectionConfig.DEFAULT);

        // Configure total max or per route limits for persistent connections
        // that can be kept in the pool or leased by the connection manager.
        connManager.setMaxTotal(100);
        connManager.setDefaultMaxPerRoute(10);
        connManager.setMaxPerRoute(new HttpRoute(new HttpHost("somehost", 80)), 20);

        // Use custom cookie store if necessary.
        CookieStore cookieStore = new BasicCookieStore();
        // Use custom credentials provider if necessary
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        // Create global request configuration
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.DEFAULT)
                .setExpectContinueEnabled(true)
                .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC))
                .build();
        // Create an HttpClient with the given custom dependencies and configuration
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connManager)
                .setDefaultCookieStore(cookieStore)
                .setDefaultCredentialsProvider(credentialsProvider)
                .setProxy(new HttpHost("myproxy", 8080))
                .setDefaultRequestConfig(defaultRequestConfig)
                .build();
        try {
            HttpGet httpget = new HttpGet("http://httpbin.org/get");
            RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig)
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .setProxy(new HttpHost("myotherproxy", 8080))
                    .build();
            httpget.setConfig(requestConfig);
            HttpClientContext context = HttpClientContext.create();
            context.setCookieStore(cookieStore);
            context.setCredentialsProvider(credentialsProvider);
            System.out.println("executing request" + httpget.getURI());
            CloseableHttpResponse response = httpClient.execute(httpget, context);
            try {
                System.out.println("-------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
                System.out.println("-------------------------------------");
                // Once the request has been executed the local context can
                // be used to examine updated state and various objects affected
                // by the request execution.

                // Last executed request
                context.getRequest();
                // Execution route
                context.getHttpRoute();
                // Target auth state
                context.getTargetAuthState();
                // Proxy auth state
                context.getTargetAuthState();
                // Cookie origin
                context.getCookieOrigin();
                // Cookie spec used
                context.getCookieSpec();
                // User security token
                context.getUserToken();
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
    }
}
