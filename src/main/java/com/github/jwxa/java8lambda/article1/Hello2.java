package com.github.jwxa.java8lambda.article1;

/**
 * ���ڲ�����ʹ�ñ��������Լ� this���ǳ����׳����ڲ�����ͨ���̳еõ��ĳ�Ա���������� Object �ķ��������ܻ���ⲿ��ĳ�Ա�ڸǣ�shadow��������δ�޶���unqualified���� this ���û�ָ���ڲ����Լ������ⲿ�ࡣ
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/6 ProjectName: coding-myself Version: 1.0
 */
public class Hello2 {


    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println(toString());
        }
    };

    public String toString(){
        return "Hello World";
    }

    public static void main(String[] args) {
        new Hello2().r1.run();
        new Hello2().r2.run();
    }
}
