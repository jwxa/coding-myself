package com.github.jwxa.java8lambda.article2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ������
 * <p>
 * ���������б�
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
        //1.���������Ascending����
        people.stream().sorted((p1,p2)->p1.ageDifference(p2)).collect(Collectors.toList());
        //����·��(Parameter Routing)�ĵ��������򣺵�һ�������ᱻ�������ö���ʣ�µĻᰴ����˳�򱻵����������롣
        people.stream().sorted(Person::ageDifference).collect(Collectors.toList());
        //����Comparator
        //Ϊ����������ԣ�Lambda���ʽ��������д��
        Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareDescending = compareAscending.reversed();
        people.stream().sorted(compareDescending).collect(Collectors.toList());
        //Comparator��max/min����
        //�����������÷ֱ����ҳ�������С�ĺ����������ˣ�
        //min��max�����ķ���ֵ��Optional����
        people.stream().min(Person::ageDifference).ifPresent(youngest-> System.out.println("Youngest: "+ youngest));
        people.stream().max(Person::ageDifference).ifPresent(youngest-> System.out.println("Youngest: "+ youngest));


    }
}
