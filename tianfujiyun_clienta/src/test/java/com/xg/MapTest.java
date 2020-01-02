package com.xg;

import com.xg.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapTest {
    /**
     * @Autor qxg
     * @Discription  此处是对jdk1.8的练习，及map的键和值的使用；
     */
    @Test
    public void get() {
        ArrayList<User> userList = new ArrayList<>();
       /* User user  ;
        for (int i = 0; i < 2 ; i++){
            user = new User();
            user.setUName("huaRen"+i);
            user.setUAge(2+i);
            user.setUName("长"+i+"号");
            user.setURemark(i+"年级");
            Optional.ofNullable(new User()).ifPresent(users->{
                userList.add(users);
            });
        }*/

        Map<String, String> map = new HashMap<>();
//        map.put("4","nihao");
//        map.put("5","nililiu ");
        // List 转化  Map
        Stream<User> distinct = userList.stream().distinct();
       /* Map<Integer, String> collect = userList.stream().collect(Collectors.toMap(User::getUAge, User::getUName))*/;// 这个装map时 ，会剔除所有之前的所有值；
//userList.stream().collect(Collectors.toMap(User::getAge, User::getName));// 这个装map时 ，会剔除所有之前的所有值；
//        map.putAll(userList.stream().collect(Collectors.toMap(User::getAge, User::getName))); // 这个会在其他的基础上进行新增
        Set<String> ints = map.keySet();
        for (String i:ints
        ) {
            System.out.println(i);
            System.out.println(map.get(i));
        }
    }
}
