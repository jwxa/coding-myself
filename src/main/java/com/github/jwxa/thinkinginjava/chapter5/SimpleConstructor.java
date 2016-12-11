package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 一个带有构造器的简单类
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class SimpleConstructor {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock();
        }
    }
}

class Rock{
    public Rock(){
        System.out.println("Rock ");
    }
}
