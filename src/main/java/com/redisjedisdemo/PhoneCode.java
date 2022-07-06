package com.redisjedisdemo;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class PhoneCode {

    public static void main(String[] args) {

        // 1 模拟发送验证码
        codeVerify("15633311145");

        // 2 验证随机码是否正确
        //confirmCode("13789976101","201426");

        /**
         *  加油 欧力给
         */


    }

    // 3 判断输入的验证码与随机码是否一致
    public static void confirmCode(String phone, String code) {
        Jedis jedis = new Jedis("localhost", 6379);
        String codeKey = "VerifyCode" + phone + ":code";
        String redisCode = jedis.get(codeKey);
        if (redisCode.equals(code)){
            System.out.println("验证成功！");
        } else {
            System.out.println("验证失败！");
        }
        jedis.close();
    }
    // 2 验证码两分钟有效
    public static void codeVerify(String phone) {

        Jedis jedis = new Jedis("localhost", 6379);
        String countKey = "VerifyCode" + phone + ":count";
        String codeKey = "VerifyCode" + phone + ":code";

        // 每个手机一天只能发送3次验证码
        String count = jedis.get(countKey);
        if (count == null){
            jedis.setex(countKey, 24*60*60, "1");
        } else if (Integer.parseInt(count) <= 2) {
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            System.out.println("今天已发送3次验证码，请明天再来！");
            jedis.close();
            return ;
        }
        
        // 获取6位随机码
        Integer randomCode = getCode();
        jedis.setex(codeKey, 1200, String.valueOf(randomCode));
        jedis.close();
    }

    // 1 生成6位随机码
    public static Integer getCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        System.out.println(code);
        return code;
    }
}
