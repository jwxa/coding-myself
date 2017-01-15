package com.github.jwxa.java8lambda.article2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 挑选元素
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class SelectElements {

    //    比如，当我们需要打印出集合中第一个以某字母开头的元素时，最“自然”的实现如下：
    public static void pickName(
            final List<String> names, final String startingLetter) {
        String foundName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }
        System.out.print(String.format("A name starting with %s: ", startingLetter));
        if (foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }
    }

    public static void pickName2(final List<String> names, final String startingLetter) {
        Optional<String> foundName = names.stream().filter(a -> a.startsWith(startingLetter)).findFirst();
        System.out.println(String.format("A name starting with %s: %s",startingLetter,foundName.orElse("No name found")));
        //当结果存在时，通过使用ifPresent方法也可以运行某一段代码，运行的代码可以通过Lambda表达式声明：
        foundName.ifPresent(name -> System.out.println("Hello " + name));
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("aaaaaaaaaaaa","bnnnnnnnnnnb");
        pickName2(names,"a");

    }


}
