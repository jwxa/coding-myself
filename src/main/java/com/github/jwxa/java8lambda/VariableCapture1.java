package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * ��������
 * ���һ���ֲ������ڳ�ʼ�����δ���޸Ĺ�����ô���ͷ�����Чֻ����Ҫ�󣬻��仰˵������ final ��Ҳ���ᵼ�±������ľֲ�����������Чֻ��������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/6 ProjectName: coding-myself Version: 1.0
 */
public class VariableCapture1 {


    public static void main(String[] args) {
        /**
         * lambda ���ʽ�� ֵ ��գ��� ���� ����
         * @param args
         */
        List<Integer> list = new ArrayList();
//        int sum = 0;
//        list.forEach(e -> { sum += e.size(); }); // Illegal, close over values

        List<Integer> aList = new ArrayList<>();
        list.forEach(e -> { aList.add(e); }); // Legal, open over variables


        int sum = list.stream().mapToInt(e->e.intValue()).sum();

    }


    Callable<String> helloCallable(String name){
        String hello = "Hello";
        return ()-> (hello+","+name);
    }
}
