package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 可变参数列表和自动包装机制可以和谐共处
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/3 ProjectName: coding-myself Version: 1.0
 */
public class AutoboxingVarargs {
    public static void f(Integer... args){
        for (Integer arg : args) {
            System.out.print(arg+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        f(new Integer(1),new Integer(2));
        f(4,5,6,7,8,9);
        f(10,new Integer(11),12);
    }
}
