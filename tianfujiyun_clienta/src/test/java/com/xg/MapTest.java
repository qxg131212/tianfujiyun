package com.xg;

import com.xg.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapTest {
    /**
     * @Autor qxg
     * @Discription  此处是对jdk1.8的练习，及map的键和值的使用；
     */
    @Test
    public void get() {
//        List<Student> userList = studentMapper.selectList(null);
        ArrayList<User> userList = new ArrayList<>();
        User user  ;
        for (int i = 0; i < 10 ; i++){
            user = new User();
            user.setName("huaren"+i);
            user.setAge("2"+i);
            user.setAddress("长安"+i+"号");
            user.setNian(i+"年级");
            userList.add(user);
        }
//        Assert.assertEquals(3, userList.size());//
        userList.forEach(System.out::println);
        Map<String, String> map = new HashMap<>();
        map.put("4","nihao");
        map.put("5","nililiu ");
        map = userList.stream().collect(Collectors.toMap(User::getAge, User::getName));// 这个装map时 ，会剔除所有之前的所有值；
//        map.putAll(userList.stream().collect(Collectors.toMap(User::getAge, User::getName))); // 这个会在其他的基础上进行新增
        Set<String> ints = map.keySet();
        for (String i:ints
        ) {
            System.out.println(i);
            System.out.println(map.get(i));
        }
    }
}
