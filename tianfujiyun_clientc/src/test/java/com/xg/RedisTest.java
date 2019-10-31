package com.xg;

import com.xg.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    public RedisUtils redisUtils;

    @Autowired
    public RedisTemplate redisTemplate;


    @Test
    public void testString() {
        redisTemplate.opsForValue().set("age", "zhangsan");
        boolean set = redisUtils.set("name", "王五");
        Object name = redisUtils.get("name");
        System.out.println(name);
    }

    //测试hash
    @Test
    public void testHash() {
        redisUtils.hset("user", "name", "wangmazi");
        redisUtils.hset("user", "age", 18);

//        Object hget = redisUtils.hget("user", "age");
//        Object ht = redisUtils.hget("user", "name");
//        System.out.println("年龄===="+hget+"姓名======"+ht);
    }

    //测试list
    @Test
    public void testList() {

      /*  List list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
        list.add("dddd");
        list.add("eeee");
        list.add("ffff");
        redisUtils.lSet("list", list);*/
        List<Object> list1 = redisUtils.lGet("list", 0, -1);
        for (Object val :
                list1) {
            System.out.println(val);
        }

    }

    //set测试
    @Test
    public void testSet() {
      /*  long l = redisUtils.sSet("set", "aaa", "bbb", "ccc", "ddd", "ddd", "ddd");
        System.out.println(l);*/

        Set<Object> set = redisUtils.sGet("set");

        for (Object val :
                set) {
            System.out.println(val);
        }
    }

    //测试zset  有序 不重复 根据score分数进行排序
    @Test
    public void testZset() {
      /*  redisUtils.ZSet("person","zhangsan",1);
        redisUtils.ZSet("person","lisi",2);
        redisUtils.ZSet("person","wangwu",10);
        redisUtils.ZSet("person","zhaoliu",4);
        redisUtils.ZSet("person","guijiaoqi",6);
        redisUtils.ZSet("person","zhuba",13);
        redisUtils.ZSet("person","jiujiu",18);*/

        //根据score从小到大
     /*   Set<String> person = redisUtils.ZRange("person", 0, -1);
        for (Object val:
                person) {
            System.out.println(val);
        }*/
        /**
         * 根据score从大到小
         */
        Set<String> person = redisUtils.ZRevRange("person", 0, -1);
        for (Object val :
                person) {
            System.out.println(val);
        }
    }

    //指定缓存失效时间
    @Test
    public void testExpire() {
        boolean name = redisUtils.expire("name", 20);
    }

    @Test
    public void testRedis() {
        //1.判断redis中是否有该value
        Object name = redisUtils.get("name");
        if (name == null) {
            //2.从数据库查询数据放置到redis
            boolean set = redisUtils.set("name", "zhangsan");
            if (set) {
                System.out.println("增加成功");
                name = "zhangsan";//数据库查询
                redisUtils.expire("name", 60);
                System.out.println("设置超时间");
            }
        }
        System.out.println(name);

    }
}
