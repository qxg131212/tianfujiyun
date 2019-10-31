package com.xg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {

    @Test
    public  void lambdaOne(){
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        // 不使用lambda表达式为每个订单加上12%的税
        List costBeforeTax1 = Arrays.asList(0.10, 200, 300, 400, 500);
        List<Integer> costBeforeTax = Arrays.asList(1, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            BigDecimal pp = new BigDecimal((cost + .12*cost));
            System.out.println(pp);

        };
        // 使用lambda表达式
        List<Integer> list = Arrays.asList(100, 200, 300, 400, 500);
        list.stream().map((cost) -> cost +  .12*cost).forEach(System.out::println);
    }
}
