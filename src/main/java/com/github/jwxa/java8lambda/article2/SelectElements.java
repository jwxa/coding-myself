package com.github.jwxa.java8lambda.article2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * ��ѡԪ��
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class SelectElements {

    //    ���磬��������Ҫ��ӡ�������е�һ����ĳ��ĸ��ͷ��Ԫ��ʱ�����Ȼ����ʵ�����£�
    public static void pickName(
            final List<String> names, final String startingLetter) {
        String foundName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }
        System.out.print(String.format("A name starting with %s: ", startingLetter));
        if (foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }
    }

    public static void pickName2(final List<String> names, final String startingLetter) {
        Optional<String> foundName = names.stream().filter(a -> a.startsWith(startingLetter)).findFirst();
        System.out.println(String.format("A name starting with %s: %s",startingLetter,foundName.orElse("No name found")));
        //���������ʱ��ͨ��ʹ��ifPresent����Ҳ��������ĳһ�δ��룬���еĴ������ͨ��Lambda���ʽ������
        foundName.ifPresent(name -> System.out.println("Hello " + name));
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("aaaaaaaaaaaa","bnnnnnnnnnnb");
        pickName2(names,"a");

    }


}
