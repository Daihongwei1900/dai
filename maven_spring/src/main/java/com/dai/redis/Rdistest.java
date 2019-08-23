package com.dai.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;
import java.util.Set;

public class Rdistest {
    public static void main(String[] args) {

    }
    @Test
    public void  test1(){
        Jedis jedis =new Jedis("localhost",6379);
        jedis.set("username","password");
        System.out.println(jedis.get("username"));
        jedis.setex("activecode",20,"hehe");
        jedis.close();
    }
    @Test
    public void test2(){
        Jedis jedis = new Jedis();
        jedis.hset("user","name","戴宏炜");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","男");
        Map<String, String> user = jedis.hgetAll("user");
        System.out.println(user);
        jedis.close();
    }

    @Test
    public void test3(){

        Jedis jedis = new Jedis();
        jedis.del("mylist");
        jedis.lpush("mylist","a","b","c");
//        System.out.println(jedis.lpop("mylist"));
        jedis.close();
        System.out.println(jedis.lrange("mylist",0,-1));
    }
    @Test
    public void test4(){
        Jedis jedis = new Jedis();
        jedis.sadd("1","1","2","3");
        Set<String> smembers = jedis.smembers("1");
        System.out.println(smembers);
        Set<String> keys = jedis.keys("");
        System.out.println(keys);
        jedis.close();
    }
    @Test
    public void test5(){
        JedisPoolConfig c = new JedisPoolConfig();
        c.setMaxTotal(50);
        c.setMaxIdle(10);
        JedisPool localhost = new JedisPool(c, "localhost", 6379);
        Jedis je = localhost.getResource();
        System.out.println(je);
    }

}
