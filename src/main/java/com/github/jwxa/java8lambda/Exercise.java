package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * http://lucida.me/blog/java-8-lambdas-insideout-language-features/
 * �ڻ��ͨ<br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class Exercise {

    public static void main(String[] args) {
        List<Person> people =  new ArrayList<>();
        people.add(new Person("cccc",11));
        people.add(new Person("aaaa",22));
        people.add(new Person("bbbb",33));
        //1.�������ʵ��̫����
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        //2.����lambda���ʽ�����ǿ���ȥ������������ࣺ
        Collections.sort(people, (Person x,Person y)->x.getName().compareTo(y.getName()));
        //3.���ܴ������˺ܶ࣬�����ĳ���̶���Ȼ�ܲ� ����������Ȼ��Ҫ����ʵ�ʵıȽϲ�������������Ƚϵ�ֵ��ԭʼ������ô�������㣩��
        // ��������Ҫ���� Comparator ��� comparing ����ʵ�ֱȽϲ�����
        Collections.sort(people, comparing((Person p) -> p.getName()));
        //4.�������Ƶ��;�̬����İ����£����ǿ��Խ�һ��������Ĵ��룺
        Collections.sort(people, comparing(p -> p.getName()));
        //5.����ע�⵽����� lambda ���ʽʵ������ getLastName �Ĵ���forwarder�����������ǿ����÷������ô�������
        Collections.sort(people, comparing(Person::getName));
        //6.���ʹ�� Collections.sort �����ĸ�������������һ�������⣺
        // ������ʹ���������࣬Ҳ�޷�Ϊʵ�� List �ӿڵ����ݽṹ�ṩ�ض���specialized���ĸ�Чʵ��
        // ���������� Collections.sort ���������� List �ӿ�
        // ���û����Ķ� List �ӿڵ��ĵ�ʱ������������� Collections ���л���һ����� List �ӿڵ�����sort()��������
        people.sort(comparing(Person::getName));
        //ex.���⣬�������Ϊ Comparator �ӿ�����һ��Ĭ�Ϸ��� reversed()������һ������Ƚ����������ǾͿ��Էǳ����׵���ǰ�����Ļ�����ʵ�ֽ�������
        people.sort(comparing(Person::getName).reversed());
    }
}