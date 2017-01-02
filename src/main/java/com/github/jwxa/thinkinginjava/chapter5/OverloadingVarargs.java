package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 自动包装机制匹配重载方法
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/3 ProjectName: coding-myself Version: 1.0
 */
public class OverloadingVarargs {

    static void f(Character... args) {
        System.out.print("first");
        for (Character arg : args) {
            System.out.print(" " + arg);
        }
        System.out.println();
    }

    static void f(Integer... args) {
        System.out.print("second");
        for (Integer arg : args) {
            System.out.print(" " + arg);
        }
        System.out.println();
    }

    static void f(Long... args){
        System.out.println("third");
    }

    public static void main(String[] args) {
        f('a','b','c');
        f(1);
        f(2,1);
        f(0);
        f(0L);
        //f(); //Won't compile --ambiguous
    }
}

