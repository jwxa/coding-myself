package com.github.jwxa.thinkinginjava.chapter5;

/**
 * �������޷�֪��Ӧ�õ����Ǹ�����
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/3 ProjectName: coding-myself Version: 1.0
 */
public class OverloadingVarargs2 {
    static void f(float i,Character ...characters){
        System.out.println("first");
    }

    static void f(Character...characters){
        System.out.println("second");
    }

    public static void main(String[] args) {
        f(1,'a');
//        f('a','b');//����
    }

}
