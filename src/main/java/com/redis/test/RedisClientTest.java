package com.redis.test;

import redis.clients.jedis.Jedis;

/**
 * redis 客户端
 * Created by yaguang.wang
 * on 2017/5/4.
 */
public class RedisClientTest {
    public static void main(String[] args) {
        try {
            Jedis jedis = new Jedis("192.168.99.100", 32768);
            jedis.set("myLover", "baiyajing");
            System.out.println("my lover " + jedis.get("myLover"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
