package com.github.jwxa.java8lambda.article1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 变量捕获<br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class VariableCapture {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.forEach((e)-> System.out.println(e));
        List<Integer> filterList = list.stream().filter((e) -> (e < 5) ? true : false).collect(Collectors.toList());
        System.out.println(filterList);

        long count =list.stream().count();
        System.out.println(count);

        long sum = list.stream().mapToInt(e->e).sum();
        System.out.println(sum);

        //规约
        long sum1 = list.stream().mapToInt(e->e).reduce(0,(x,y)->x+y);
        System.out.println(sum1);


    }

}
