package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 可以通过调用某个方法来提供初值3 下面这样写就不对
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/24 ProjectName: coding-myself Version: 1.0
 */
public class MethodInit3 {

//    int j = g(i);//"向前引用" 警告 Illegal forward reference
    int i = f();
    int f(){
        return 11;
    }

    int g(int n){
        return n*10;
    }
}
