package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 通过添加一个非可变参数解决2中的问题
 * <p>
 * 方法描述列表
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
        f('a','b');//解决报错
    }

}
