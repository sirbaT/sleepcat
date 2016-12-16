package com.httpclient.learning.char1_1;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;

/**
 * Http response 相应报文解析
 * Created by Administrator on 2016/11/28.
 */
public class HttpResponseDome {
    public static void main(String[] args) {
        // 1.2 Http 响应
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(response.getStatusLine().toString());


        HttpResponse response1 = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_CREATED, "CREATED");
        response1.addHeader("Set-Cookie", "c1=a; path=\"/\",c3=c;domain=\"localhost\"");
        response1.addHeader("Set-Cookie", "c2=b;path\"/\",c3=c;domain=\"localhost\"");
        //Header h1 = response1.
    }
}
