package com.github.jwxa.java8lambda.article2;

import java.util.Arrays;
import java.util.List;

/**
 * stream 入门
 * http://ifeve.com/stream/
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/22 ProjectName: coding-myself Version: 1.0
 */
public class AtFirst {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        System.out.println("sum is:"+nums.stream().filter(num -> num != null).
                distinct().mapToInt(num -> num * 2).
                peek(System.out::println).skip(2).limit(4).sum());
    }
}
