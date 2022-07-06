package com.redisjedisdemo;

import redis.clients.jedis.Jedis;

public class JedisDemo {
    public static void main(String[] args) {
        // 创建Jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String ping = jedis.ping();
        System.out.println(ping);
    }
}
