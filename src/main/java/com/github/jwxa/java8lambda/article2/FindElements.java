package com.github.jwxa.java8lambda.article2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * http://blog.csdn.net/dm_vincent/article/details/40340291
 * 寻找元素
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class FindElements {

    public static void main(String[] args) {
        final List<String> friends = new ArrayList<String>();
        //第一层
//        final List<String> startsWithN = friends.stream()
//                .filter(name -> name.startsWith("N"))
//                .collect(Collectors.toList());
        //第二层
//        final List<String> startsWithN = friends.stream()
//                .filter(checkIfStartsWith("N"))
//                .collect(Collectors.toList());
        //第三层
//        缩小作用域 1\2\3同样表示  不断精简
        final Function<String, Predicate<String>> startsWithLetter =
                (String letter) -> {
                    Predicate<String> checkStartsWith = (String name) -> name.startsWith(letter);
                    return checkStartsWith;
                };
        final Function<String,Predicate<String>> startsWithLetter2 =
                (String letter)->(String name)-> name.startsWith(letter);
        final Function<String,Predicate<String>> startsWithLetter3= letter->name->name.startsWith(letter);
        final long countFriendsStartB = friends.stream().filter(startsWithLetter3.apply("B")).count();

    }
//    实际上，使用static来实现以上的高阶函数并不是一个好主意。可以将作用域缩小一些：
    public static Predicate<String> checkIfStartsWith(String letter){
        return  a->a.startsWith(letter);
    }


}
