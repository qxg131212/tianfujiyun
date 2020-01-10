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
        if(flag) {
            try {
                String sq = ss.substring(ss.indexOf("（") + 1, ss.indexOf("）"));
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
        // *****************第二模块*****************************
        Student s1 = new Student("1","张三", "21", "2");
        Student s2 = new Student("2","李四", "22", "3");
        Student s3 = new Student("3","王五", "12", "4");
        Student s4 = new Student("4","王五", "12", "4");

        List<Student> studentList = Arrays.asList(s1, s2, s3,s4);
        List<String> collect3 = studentList.stream().map(student -> student.getSid()).collect(Collectors.toList());
        System.out.println(collect3+"---9090");

        //过滤 年龄大于 21岁，  status为3的student();
        studentList.stream().filter(u -> Integer.valueOf(u.getSage()) >= 21 && Integer.valueOf(u.getStatus()) == 3).forEach(e ->{
            System.out.println(e.getSname());
        });
        // distinct() 去重Student();
        List<Student> collect = studentList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect +"去重");
        //排序 sorted
        List<Student> collect1 = studentList.stream()
                .sorted(Comparator.comparing(s -> s.getSage()))
                .collect(Collectors.toList());
        System.out.println(collect1+"排序");

        //****test************
        Map<String, Object> map = new HashMap<>();
        map = studentList.stream().collect(Collectors.toMap(Student::getSid, Student::getSname));// 这个装map时 ，会剔除所有之前的所有值；
        //  map.putAll(userList.stream().collect(Collectors.toMap(Student::getSage, Student::getSname))); // 这个会在其他的基础上进行新增
        Set<String> ints = map.keySet();
        for (String i:ints
        ) {
            System.out.println(i);
            System.out.println(map.get(i));
        }
        HashMap<String, String> collect2 = studentList.stream()
                .sorted(Comparator.comparing(Student::getSid))
                .collect(Collectors.toMap(Student::getSid, Student::getSname, (k1, k2) -> k1, HashMap::new));
        System.out.println(collect2);

       /*
        String s = null;
        BigDecimal bigDecimal = new BigDecimal(12); //被除数
        BigDecimal target = new BigDecimal(36);
        BigDecimal multiply = target.divide(bigDecimal, 3, BigDecimal.ROUND_HALF_UP);
        System.out.println("商为"+multiply);
        BigDecimal subtract = target.subtract(multiply).subtract(multiply).subtract(multiply); //subtract 做减法36-3-3-3 =27
        System.out.println(subtract);
        System.out.println(bigDecimal+"====");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileWriter fw = new FileWriter("d:/cc/Date.log",true);
            PrintWriter pw = new PrintWriter(fw);
            while((s = br.readLine())!= null) {
                if (s.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(s.toUpperCase());
                pw.println("------");
                pw.println(s.toUpperCase());
                pw.flush();

                pw.println("=======" + new Date() + "========");
                pw.flush();
                pw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }

}
