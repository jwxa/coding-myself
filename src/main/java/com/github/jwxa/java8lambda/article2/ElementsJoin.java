package com.github.jwxa.java8lambda.article2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 元素连接
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class ElementsJoin {
    public static void main(String[] args) {
        List<String> friends = Arrays.asList("John", "Tom", "Mike");
        System.out.println( String.join(",",friends));
//        Stream类型还定义了一个collect方法用来完成一些常见的归约操作：
        System.out.println(friends.stream().map(String::toUpperCase).collect(Collectors.joining(", ")));
    }
}
