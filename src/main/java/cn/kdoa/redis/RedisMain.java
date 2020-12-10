package cn.kdoa.redis;

import cn.kdoa.entity.Users;
import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RedisMain {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("recooked", "welcome");
        jedis.expire("recooked",10);

       // key();
/*        Users u1=new Users(1,"张三");
        Users u2=new Users(2,"李四");
        List list=new ArrayList();
        list.add(u1);
        list.add(u2);
        System.out.println(JSON.toJSON(list));*/

    }
    /**
     * Keys
     */
    public static void key()
    {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");
        System.out.println("连接成功");


        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
    /**
     * 列表
     */
    public static void list()
    {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        jedis.auth("123456");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
    }
    /**
     * 字符串
     */
    public void str(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        // 如果 Redis 服务设置来密码，需要下面这行，没有就不需要
        jedis.auth("123456");
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("recooked", "welcome");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("recooked"));
    }
}
