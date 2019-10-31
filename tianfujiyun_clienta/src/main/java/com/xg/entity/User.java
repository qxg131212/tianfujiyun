package com.xg.entity;

import lombok.Data;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Data
public class User {

    private String name;

    private String age;

    private String address;

    private String nian;

    public User() {
    }

    ;

    public User(String age, String address) {
        this.age = age;
        this.address = address;
    }

    public User(String name, String age, String address, String nian) {
        this.name = name;
        this.age = age;
        //this.address = address;
        this.nian = nian;
    }

 /*   public static void main(String[] args) {
        //转化为时间戳  毫秒值
      long time1 = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
       System.out.println(time1);
        long time2 = System.currentTimeMillis();
        System.out.println(time2+"=======");
        //时间戳转化为localdatetime
        DateTimeFormatter df= DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss.SSS");
        System.out.println("+++"+df);
        System.out.println(df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time1), ZoneId.of("Asia/Shanghai"))));
    }*/

    public static void main(String[] args) {
        // init data 合并
        List<Map<String, Object>> query = new ArrayList<>();
        Map<String, Object> e1 = new HashMap<>();
        e1.put("number", 3);
        e1.put("name", "1");
        e1.put("age", "0101019");
        e1.put("yuefen", 3);
        e1.put("price", 500);
        query.add(e1);

        Map<String, Object> e2 = new HashMap<>();
        e2.put("number", 99);
        e2.put("name", "1");
        e2.put("age", "A001");
        e2.put("yuefen", 3);
        e2.put("price", 300);
        query.add(e2);

        Map<String, Object> e3 = new HashMap<>();
        e3.put("number", 44);
        e3.put("name", "1");
        e3.put("age", "A002");
        e3.put("yuefen", 5);
        e3.put("price", 300);
        query.add(e3);
        List<List<Map<String, Object>>> listOne = new ArrayList<>();
        query.stream().collect(Collectors.groupingBy(m -> m.get("name").toString() + "#" + m.get("price"))).forEach((k, value) -> {
            listOne.add(value);
        });
        System.out.println(listOne);


        List<Map<String, Object>> result1 = query.stream().collect(Collectors.groupingBy(e -> e.get("number")))
                .entrySet().stream().map(e -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("userlist", e.getValue());
                    map.put("xinList", e.getKey());
                    return map;
                }).collect(Collectors.toList());
        System.out.println(result1);
        //***************************************
        List<HashMap<String, Object>> group_no = query.stream()
                .collect(Collectors.groupingBy(q -> q.get("group_no")))
                .entrySet()
                .stream()
                .map(e -> {
                    HashMap<String, Object> inner = new HashMap<>();
                    List<Map<String, Object>> newList = e.getValue().stream().map(v -> {
                        v.remove("group_no");
                        return v;
                    }).collect(Collectors.toList());
                    inner.put("attributelist", newList);
                    inner.put("group_no", e.getKey());
                    return inner;
                }).collect(Collectors.toList());
        //System.out.println(JSON.toJSONString(group_no));
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, List<Map<String, Object>>> glist = list.stream().collect(Collectors.groupingBy(e -> e.get("name").toString()));

        glist.forEach((k, slist) -> {
            Map<String, Object> nmap = new HashMap<>();
            slist.stream().collect(Collectors.summarizingLong(e -> Integer.valueOf(e.get("price").toString())));
            nmap.put("name", slist.get(0).get("name"));

            System.out.println(nmap);
        });
        glist.forEach((k, slist) -> {
            Map<String, Object> nmap = new HashMap<>();
            IntSummaryStatistics sumcc = slist.stream().collect(Collectors.summarizingInt(e -> Integer.valueOf(e.get("price").toString())));
            nmap.put("name", slist.get(0).get("name"));
            nmap.put("price", sumcc.getSum());//求和
            nmap.put("age", sumcc.getMax());//求和
            result.add(nmap);
        });
        System.out.println("--------testMerge-------------");
        result.forEach(x -> {
            System.out.println(x);
        });
        //对member_num求和，其他字段原样返回
        glist.forEach((k, slist) -> {
            Map<String, Object> nmap = new HashMap<>();
            IntSummaryStatistics sumcc = slist.stream().collect(Collectors.summarizingInt(e -> Integer.valueOf(e.get("member_num").toString())));
            nmap.put("card_id", slist.get(0).get("card_id"));
            nmap.put("channel_id", slist.get(0).get("channel_id"));
            nmap.put("member_num", sumcc.getSum());//求和
            nmap.put("store_id", slist.get(0).get("store_id"));
            nmap.put("area_id", slist.get(0).get("area_id"));
            nmap.put("shop_type", slist.get(0).get("shop_type"));
            result.add(nmap);
        });
    }
}

































