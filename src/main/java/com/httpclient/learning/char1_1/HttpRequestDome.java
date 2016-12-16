package com.httpclient.learning.char1_1;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Http request 对象 URI dome
 * Created by yaguang.wang on 2016/11/28.
 */
public class HttpRequestDome {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.google.com")
                .setPath("/search")
                .setParameter("q", "httpclient")
                .setParameter("btnG", "Google Search")
                .setParameter("aq", "f")
                .setParameter("oq", "")
                .build();
        HttpGet httpGet = new HttpGet(uri);
        System.out.println(httpGet.getURI());
    }
}
