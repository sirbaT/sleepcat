package com.httpclient.learning.mongodb;

import com.mongodb.MongoClient;

/**
 * 连接mongo的示例
 * Created by yaguang.wang on 2016/12/14.
 */
public class ConnectMongo {
    public static void main(String[] args) {
        MongoClient client = new MongoClient("localhost", 27017);
        //MongoDatabase mdb = client.getDatabase("admin");
        System.out.println(client.getConnectPoint());
        client.close();
    }
}
