package com.github.jwxa.java8lambda.article2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
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

        //2.���رȽ� ����Ҫͨ����������������ʱ����Ȼ����ʹ��sorted������
        final Function<Person, String> byName = person -> person.getName();
        final Function<Person,Integer> byAge  = person -> person.getAge();
        people.stream().sorted(Comparator.comparing(byName).thenComparing(byAge)).collect(Collectors.toList());

        //3.ʹ��collect������Collectors��
        List<Person> olderThan20 = people.stream().filter(p->p.getAge()>20)
                //��һ��������ʾ������δ���Ŀ������
                //�ڶ���������ʾ��������ռ�Ԫ�ص�������
                //������������ʾ������κϲ����Ŀ������
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
//        ��������������һ������������ŵ㣺
//        ������ͼ�����ԣ���������ࡣ
//        �����ײ��л�����Ϊû����ʽ�ض��κζ�������޸ĵĲ���
        List<Person> olderThan20a = people.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.toList());

        //groupingBy���÷�
        Map<Integer,List<String>> groupingByAge = people.stream().collect(
                Collectors
                        .groupingBy(
                                //��һ����Ϊ���������ڶ�����Ϊ�Է��������н�һ��������collector��
                                Person::getAge,Collectors.mapping(Person::getName,Collectors.toList()
                                ))
        );
        //�پ�һ��������һ������ӣ�������Ҫ�������ֵ�����ĸ���з��࣬�������������Ը�����ĸ��ͷ�����������ˡ�
        Comparator cmpByAge = Comparator.comparing(Person::getAge);
        Map<Character, Optional<Person>> oldestPersonInEachAlphabet =
                people.stream()
                        .collect(Collectors.groupingBy(p->p.getName().charAt(0)
                                ,Collectors.reducing(BinaryOperator.maxBy(cmpByAge))));
        //���ϵ�groupingBy�����ĵڶ�������ִ���˹�Լ(Reduction)������������֮ǰ��ӳ��(Mapping)����������������BinaryOperator�ж���ľ�̬����maxBy��
        //�ڹ�Լ�����У�ÿ�ζ���ȡ���������Ԫ���нϴ���Ǹ������͵õ������������������Ǹ�Ԫ�ء�

    }
}
