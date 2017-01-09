package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 变量捕获
 * 如果一个局部变量在初始化后从未被修改过，那么它就符合有效只读的要求，换句话说，加上 final 后也不会导致编译错误的局部变量就是有效只读变量。
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/6 ProjectName: coding-myself Version: 1.0
 */
public class VariableCapture1 {


    public static void main(String[] args) {
        /**
         * lambda 表达式对 值 封闭，对 变量 开放
         * @param args
         */
        List<Integer> list = new ArrayList();
//        int sum = 0;
//        list.forEach(e -> { sum += e.size(); }); // Illegal, close over values

        List<Integer> aList = new ArrayList<>();
        list.forEach(e -> { aList.add(e); }); // Legal, open over variables


        int sum = list.stream().mapToInt(e->e.intValue()).sum();

    }


    Callable<String> helloCallable(String name){
        String hello = "Hello";
        return ()-> (hello+","+name);
    }
}
