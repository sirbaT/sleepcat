package com.xiaoyadecaihong.sleepcat;

import com.httpclient.learning.HttpClientLearning;

import java.io.File;
import java.io.IOException;

/**
 * open server
 * Created by yaguang.wang on 2016/11/18.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // System.out.println("First project on web");
        HttpClientLearning<String> learner = new HttpClientLearning<String>();
        // System.out.println(learner.get("http://www.baidu.com"));
        //System.out.println(learner.get("http://www.baidu.com", HttpClientLearning.DEFAULT_STRING_RESPONSE));
        HttpClientLearning<File>  fileLearner = new HttpClientLearning<File>();
        File file = fileLearner.get("http://www.baidu.com",HttpClientLearning.getFileResponse("D:test.txt"));
        file.createNewFile();
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
   }
}
