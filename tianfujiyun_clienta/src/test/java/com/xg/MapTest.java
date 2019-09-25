package com.xg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapTest {
    /**
     * @Autor qxg
     * @Discription  此处是对jdk1.8的练习，及map的键和值的使用；
     */
/*    @Test
    public void get() {
        List<Student> userList = studentMapper.selectList(null);
//        Assert.assertEquals(3, userList.size());//
        userList.forEach(System.out::println);
        Map<String, String> map = new HashMap<>();
        map.put("4","nihao");
        map.put("5","nililiu ");
        map.put("6","99999");
        map.put("7","99999");
//        map = userList.stream().collect(Collectors.toMap(Student::getSid, Student::getSname));// 这个装map时 ，会剔除所有之前的所有值；
        map.putAll(userList.stream().collect(Collectors.toMap(Student::getSid, Student::getSname))); // 这个会在其他的基础上进行新增
        Set<String> ints = map.keySet();
        for (String i:ints
        ) {
            System.out.println(i);
            System.out.println(map.get(i));
        }
    }*/
}
