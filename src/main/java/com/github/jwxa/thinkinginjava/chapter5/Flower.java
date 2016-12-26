package com.github.jwxa.thinkinginjava.chapter5;

/**
 * �ڹ������е��ù�����
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/24 ProjectName: coding-myself Version: 1.0
 */
public class Flower {
    int petalCount = 0;
    String s = "initial value";
    Flower(int petals){
        petalCount = petals;
        System.out.println("Constructor w/ int arg only , petalCount = " + petalCount);

    }

    Flower(String ss){
        System.out.println("Constructor w/ String arg only , s = "+ss);
        s = ss;
    }

    Flower(String s ,int petals){
        this(petals);
        //���ܿ�����this����һ������������ȴ���ܵ������������⣬���뽫������������������ʼ��
//        this(s);//Can't call two !
        this.s = s;
        System.out.println("String & int args");
    }

    Flower(){
        this("hi",47);
        System.out.println("default constructor (no args)");
    }

    void printPetalCount(){
        //��������֮�⣬��������ֹ�������κη����е��ù�����
//        this(11);//Not inside non-constructor
        System.out.println("petalCount = " + petalCount + " , s = " + s);
    }

    public static void main(String[] args) {
        Flower f = new Flower();
        f.printPetalCount();
    }


}
