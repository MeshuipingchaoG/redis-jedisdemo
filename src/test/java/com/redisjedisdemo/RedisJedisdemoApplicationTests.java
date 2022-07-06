package com.redisjedisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

@SpringBootTest
class RedisJedisdemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void getKeys() {
        Jedis jedis = new Jedis();

        // setting many keys
        jedis.mset("k1", "v1", "k2", "v2");
        List<String> values = jedis.mget("k1", "k2");
        System.out.println(values);
        System.out.println("===============key的名称===========");
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }


    @Test
    public void test() {
        Jedis jedis = new Jedis("localhost", 6379);

        jedis.lpush("name", "chenzhiwei", "zhangsan","lisi");
        List<String> list = jedis.lrange("name", 0, -1);

        jedis.rpush("k1","v1", "v2", "v3");
        List<String> k1 = jedis.lrange("k1", 0, -1);
        System.out.println(k1);
        System.out.println(list);
    }

    @Test
    public void test1() {
        Jedis jedis = new Jedis("localhost", 6379);

        jedis.rpoplpush("name", "k1");
        List<String> k1 = jedis.lrange("k1", 0, -1);

        System.out.println(k1);
    }
}


