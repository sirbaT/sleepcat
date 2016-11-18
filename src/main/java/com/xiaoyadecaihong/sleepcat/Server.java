package com.xiaoyadecaihong.sleepcat;

import com.httpclient.learning.HttpClientLearning;

import java.io.IOException;

/**
 * open server
 * Created by yaguang.wang on 2016/11/18.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // System.out.println("First project on web");
        HttpClientLearning learner = new HttpClientLearning();
        // System.out.println(learner.get("http://www.baidu.com"));
        System.out.println(learner.get("http://www.baidu.com", HttpClientLearning.DEFAULT_STRING_RESPONSE));
    }
}
