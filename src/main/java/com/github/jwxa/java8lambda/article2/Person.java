package com.github.jwxa.java8lambda.article2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d",name,age);
    }

    public int ageDifference(final Person other) {
        return age - other.age;
    }

    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));
        //1.对年龄进行Ascending排序：
        people.stream().sorted((p1,p2)->p1.ageDifference(p2)).collect(Collectors.toList());
        //参数路由(Parameter Routing)的第三个规则：第一个参数会被当做调用对象，剩下的会按照其顺序被当做参数传入。
        people.stream().sorted(Person::ageDifference).collect(Collectors.toList());
        //重用Comparator
        //为了提高重用性，Lambda表达式可以这样写：
        Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareDescending = compareAscending.reversed();
        people.stream().sorted(compareDescending).collect(Collectors.toList());
        //Comparator和max/min方法
        //下面代码的作用分别是找出年龄最小的和年龄最大的人：
        //min和max方法的返回值是Optional对象。
        people.stream().min(Person::ageDifference).ifPresent(youngest-> System.out.println("Youngest: "+ youngest));
        people.stream().max(Person::ageDifference).ifPresent(youngest-> System.out.println("Youngest: "+ youngest));


    }
}
