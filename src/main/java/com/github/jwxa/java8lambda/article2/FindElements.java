package com.github.jwxa.java8lambda.article2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * http://blog.csdn.net/dm_vincent/article/details/40340291
 * Ѱ��Ԫ��
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class FindElements {

    public static void main(String[] args) {
        final List<String> friends = new ArrayList<String>();
        //��һ��
//        final List<String> startsWithN = friends.stream()
//                .filter(name -> name.startsWith("N"))
//                .collect(Collectors.toList());
        //�ڶ���
//        final List<String> startsWithN = friends.stream()
//                .filter(checkIfStartsWith("N"))
//                .collect(Collectors.toList());
        //������
//        ��С������ 1\2\3ͬ����ʾ  ���Ͼ���
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
//    ʵ���ϣ�ʹ��static��ʵ�����ϵĸ߽׺���������һ�������⡣���Խ���������СһЩ��
    public static Predicate<String> checkIfStartsWith(String letter){
        return  a->a.startsWith(letter);
    }


}
