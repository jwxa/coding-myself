package com.github.jwxa.java8lambda.article2;

import java.util.Arrays;
import java.util.List;

/**
 * 集合归约
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class CollectionReduction {
    public static void main(String[] args) {
        List<String> friends = Arrays.asList("John", "Tom", "Mike");
        System.out.println("Total number of characters in all names: " +
                friends.stream()
                        .mapToInt(name -> name.length())
                        .sum());

        //但是归根到底，这些方法最终使用到的是一个叫做reduce()的方法。
        //reduce方法的工作原理，可以这样概括：
        // 在对一个集合中的元素按照顺序进行两两操作时，根据某种策略来得到一个结果，
        // 得到的结果将作为一个元素参与到下一次操作中，最终这个集合会被归约成为一个结果。这个结果也就是reduce方法的返回值。

        //因此，当我们需要寻找并打印一个集合中最长的名字时(长度相同时，打印第一个)，可以如下实现
        friends.stream().reduce((name1,name2)->name1.length()>=name2.length()?name1:name2).ifPresent(name->System.out.println(String.format("A longest name: %s", name)));
//
//        另外需要注意的几点：
//
//        reduce方法返回的对象类型时Optional，这是因为待操作的集合可能是空的。
//        当集合只有一个元素时，reduce会立即将该元素作为实际结果以Optional类型返回，不会调用传入的Lambda表达式。
//        reduce方法是会按照集合的顺序对其元素进行两两操作的，可以额外传入一个值作为“基础值”或者“默认值”，那么在第一次进行两两操作时，第一个操作对象就是这个额外传入的值，第二个操作对象是集合中的第一个元素
        final String steveOrLonger = friends.stream().reduce("Steve",(name1,name2)->name1.length()>=name2.length()?name1:name2);

    }
}
