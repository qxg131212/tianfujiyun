package com.xg.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sid;

    private String sname;

    private String sage;

    private String  status;

    public Student() {
    }

    public Student(String sid, String sname, String sage, String status) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.status = status;
    }

    public static void main(String[] args) {
        String ss = "你好的奥迪900881（0分）";
        boolean flag = false;
        String regex="[^\\(\\)]+";
        Pattern compile1 = Pattern.compile(regex);
        Matcher matcher1 = compile1.matcher(ss);
        flag  = matcher1.matches();
        System.out.println(flag+"--9999");
        if(flag) {
            try {
                String sq = ss.substring(ss.indexOf("（") + 1, ss.indexOf("）"));
                System.out.println(sq);
                String  reg = "[0-9]{1,}分";
                Pattern compile = Pattern.compile(reg);
                Matcher matcher = compile.matcher(sq);
                flag = matcher.matches();
                System.out.println(flag+"------------");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(false);
            }
        } else {
            System.out.println(flag+"=======");
        }
    }

}
