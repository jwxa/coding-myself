package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class SimpleConstructor2 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
             new Rock2(i);
        }
    }
}
class Rock2{
    Rock2(int i){
        System.out.println("Rock" + i);
    }
}