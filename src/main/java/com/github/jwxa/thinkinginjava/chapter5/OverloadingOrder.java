package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 参数顺序的不同也足以区分两个方法。但是不建议使用，会使代码难以维护
 * <p>
 * 方法描述列表
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
