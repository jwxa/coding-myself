package com.github.jwxa.thinkinginjava.chapter5;

/**
 * ͨ�����һ���ǿɱ�������2�е�����
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/3 ProjectName: coding-myself Version: 1.0
 */
public class OverloadingVarargs3 {
    static void f(float i,Character ...characters){
        System.out.println("first");
    }

    static void f(char c,Character...characters){
        System.out.println("second");
    }

    public static void main(String[] args) {
        f(1,'a');
        f('a','b');//�������
    }

}
