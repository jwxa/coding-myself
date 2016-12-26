package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 每个基本类型数据成员都有初始值
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/24 ProjectName: coding-myself Version: 1.0
 */
public class InitialValues {
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;
    void printInitialValues(){
        System.out.println("Data type\tInitial value");
        System.out.println("boolean\t"+t);
        System.out.println("char\t["+c+"]");
        System.out.println("byte\t"+b);
        System.out.println("short\t"+s);
        System.out.println("int\t"+i);
        System.out.println("long\t"+l);
        System.out.println("float\t"+f);
        System.out.println("double\t"+d);
        System.out.println("reference\t"+reference);
    }

    public static void main(String[] args) {
        InitialValues iv = new InitialValues();
        iv.printInitialValues();
    }
}
