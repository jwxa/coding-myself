package com.github.jwxa.java8lambda.article1;

/**
 * ������ڲ��࣬lambda ���ʽ�������ʮ�ּ򵥣�������ӳ��ࣨsupertype���м̳��κα�������Ҳ��������һ���µ�������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/6 ProjectName: coding-myself Version: 1.0
 */
public class Hello {
    Runnable r1 = ()-> System.out.println(this);

    Runnable r2 = ()-> System.out.println(toString());

    public String toString(){
        return "Hello World";
    }

    public static void main(String[] args) {
        new Hello().r1.run();
        new Hello().r2.run();
    }

}
