package com.github.jwxa.java8lambda.article2;

import java.util.Arrays;
import java.util.List;

/**
 * ���Ϲ�Լ
 * <p>
 * ���������б�
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

        //���ǹ�����ף���Щ��������ʹ�õ�����һ������reduce()�ķ�����
        //reduce�����Ĺ���ԭ����������������
        // �ڶ�һ�������е�Ԫ�ذ���˳�������������ʱ������ĳ�ֲ������õ�һ�������
        // �õ��Ľ������Ϊһ��Ԫ�ز��뵽��һ�β����У�����������ϻᱻ��Լ��Ϊһ�������������Ҳ����reduce�����ķ���ֵ��

        //��ˣ���������ҪѰ�Ҳ���ӡһ���������������ʱ(������ͬʱ����ӡ��һ��)����������ʵ��
        friends.stream().reduce((name1,name2)->name1.length()>=name2.length()?name1:name2).ifPresent(name->System.out.println(String.format("A longest name: %s", name)));
//
//        ������Ҫע��ļ��㣺
//
//        reduce�������صĶ�������ʱOptional��������Ϊ�������ļ��Ͽ����ǿյġ�
//        ������ֻ��һ��Ԫ��ʱ��reduce����������Ԫ����Ϊʵ�ʽ����Optional���ͷ��أ�������ô����Lambda���ʽ��
//        reduce�����ǻᰴ�ռ��ϵ�˳�����Ԫ�ؽ������������ģ����Զ��⴫��һ��ֵ��Ϊ������ֵ�����ߡ�Ĭ��ֵ������ô�ڵ�һ�ν�����������ʱ����һ�������������������⴫���ֵ���ڶ������������Ǽ����еĵ�һ��Ԫ��
        final String steveOrLonger = friends.stream().reduce("Steve",(name1,name2)->name1.length()>=name2.length()?name1:name2);

    }
}
