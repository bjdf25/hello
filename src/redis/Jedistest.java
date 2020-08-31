package redis;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class Jedistest {

    /**
     * @test
     *
     */
    public static void main(String[] args) {
        test1();
    }
    public  static void test(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("username","zhangsan");
        jedis.close();

    }
    public static void test1(){
        Jedis jedis = new Jedis();
        jedis.hset("myhash","username","zhangsan");
        jedis.hset("myhash","age","23");
        jedis.hset("myhash","gender","female");
        Map<String, String> myhash = jedis.hgetAll("myhash");
        Set<String> keySet = myhash.keySet();
        for (String key : keySet) {
            String value = myhash.get(key);
            System.out.println(key + ":" + value);
        }


    }
}
