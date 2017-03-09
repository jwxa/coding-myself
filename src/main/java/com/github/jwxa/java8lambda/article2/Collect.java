package com.github.jwxa.java8lambda.article2;


import com.google.common.collect.HashBasedTable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

/**
 * Collect.of  创建 HashBasedTable
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/3/3 ProjectName: coding-myself Version: 1.0
 */
public class Collect {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("xf",26),
                new Person("jwxa",26)
        );

        HashBasedTable<String,String,Person> result = list.parallelStream()
                .collect(
                        Collector.of(
                                HashBasedTable::create,
                                (table,person)-> table.put(person.getName(),person.getAge()+"",person),
                                (table1, table2) -> {
                                    table1.putAll(table2);
                                    return table1;
                                }));


        System.out.println(result);
    }
}
