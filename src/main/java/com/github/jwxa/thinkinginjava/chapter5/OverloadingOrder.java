package com.github.jwxa.thinkinginjava.chapter5;

/**
 * ����˳��Ĳ�ͬҲ���������������������ǲ�����ʹ�ã���ʹ��������ά��
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class OverloadingOrder {
    public static void main(String[] args) {
        f("String first",11);
        f(99,"Int first");
    }


    static  void f(String s, int i){
        System.out.println("String :" + s + " , int : "+ i);
    }

    static void f(int i,String s){
        System.out.println("int :"+ i + ", String :" +s);
    }
}
