package com.github.jwxa.java8lambda.article2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
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

        //2.多重比较 当需要通过名字来进行排序时，仍然可以使用sorted方法：
        final Function<Person, String> byName = person -> person.getName();
        final Function<Person,Integer> byAge  = person -> person.getAge();
        people.stream().sorted(Comparator.comparing(byName).thenComparing(byAge)).collect(Collectors.toList());

        //3.使用collect方法和Collectors类
        List<Person> olderThan20 = people.stream().filter(p->p.getAge()>20)
                //第一个参数表示的是如何创建目标容器
                //第二个参数表示的是如何收集元素到容器中
                //第三个参数表示的是如何合并多个目标容器
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
//        下面我们来分析一下上述代码的优点：
//        代码意图更明显，更清晰简洁。
//        更容易并行化，因为没有显式地对任何对象进行修改的操作
        List<Person> olderThan20a = people.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.toList());

        //groupingBy的用法
        Map<Integer,List<String>> groupingByAge = people.stream().collect(
                Collectors
                        .groupingBy(
                                //第一个作为分类器，第二个作为对分类结果进行进一步操作的collector。
                                Person::getAge,Collectors.mapping(Person::getName,Collectors.toList()
                                ))
        );
        //再举一个更复杂一点的例子，我们需要根据名字的首字母进行分类，分类结果是名字以该首字母起头的年龄最大的人。
        Comparator cmpByAge = Comparator.comparing(Person::getAge);
        Map<Character, Optional<Person>> oldestPersonInEachAlphabet =
                people.stream()
                        .collect(Collectors.groupingBy(p->p.getName().charAt(0)
                                ,Collectors.reducing(BinaryOperator.maxBy(cmpByAge))));
        //以上的groupingBy方法的第二个参数执行了归约(Reduction)操作，而不是之前的映射(Mapping)操作。并且利用了BinaryOperator中定义的静态方法maxBy。
        //在归约过程中，每次都会取参与的两个元素中较大的那个。最后就得到了整个集合中最大的那个元素。

    }
}
