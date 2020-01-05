package com.xg.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@TableName("q_user")
@Data
public class User implements Serializable {

    private String u_id;

    private String u_name;

    private int u_age;

    private String u_address;

    private String u_old_address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date u_create_time;

    private boolean u_delete;

    private String u_remark;

    private String u_education;

    private String u_occupation;

    private String u_industry;

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
        // 以name 和 price 分组相同的分组 ，
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

            System.out.println(nmap +"=====");
        });
        glist.forEach((k, slist) -> {
            Map<String, Object> nmap = new HashMap<>();
            IntSummaryStatistics sumcc = slist.stream().collect(Collectors.summarizingInt(e -> Integer.valueOf(e.get("price").toString())));
            nmap.put("name", slist.get(0).get("name"));
            nmap.put("price", sumcc.getSum());//求和
            nmap.put("age", sumcc.getMax());//
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

































