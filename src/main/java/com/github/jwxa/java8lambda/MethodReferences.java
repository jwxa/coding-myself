package com.github.jwxa.java8lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 方法引用<br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class MethodReferences {
    //假设我们要按照 name 或 age 为 Person 数组进行排序
    public static void main(String[] args) {
        Person[] people = new Person[]{new Person("cccdd", 1), new Person("bbbbb", 60)};
//        Comparator<Person> comparator = Comparator.comparing(e->e.getName());
        //在这里我们可以用方法引用代替lambda表达式：
        Comparator<Person> comparator = Comparator.comparing(Person::getName);
        Arrays.sort(people, comparator);
        System.out.println(Arrays.asList(people));
    }
}

class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}

