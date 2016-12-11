package com.github.jwxa.thinkinginjava.chapter3;

/**
 * 直接常量
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/10 ProjectName: coding-myself Version: 1.0
 */
public class Literals {

    public static void main(String[] args) {
        int i1= 0x2f;
        System.out.println(Integer.toBinaryString(i1));
        int i2=0X2F;
        System.out.println(Integer.toBinaryString(i2));
        int i3=0177;
        System.out.println(Integer.toBinaryString(i3));
        char c = 0xffff;
        System.out.println("c:"+Integer.toBinaryString(c));
        byte b = 0x7f;
        System.out.println("b:"+Integer.toBinaryString(b));
        short s = 0x7fff;
        System.out.println("s:"+Integer.toBinaryString(s));
        long n1 = 200L;
        long n2 = 200l;
        long n3 =200;
        float f1 = 1;
        float f2 = 1F;
        float f3 = 1f;
        double d1 = 1d;
        double d2 = 1D;

    }
}
