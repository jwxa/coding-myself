package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 可以通过调用某个方法来提供初值2 方法也可以带有参数
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/24 ProjectName: coding-myself Version: 1.0
 */
public class MethodInit2 {
    int i =f();
    int j =g(i);
    int f(){
        return 11;
    }
    int g(int n){
        return n*10;
    }
}
