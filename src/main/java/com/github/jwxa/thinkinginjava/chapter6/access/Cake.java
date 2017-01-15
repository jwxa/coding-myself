package com.github.jwxa.thinkinginjava.chapter6.access;

/**
 * 默认包方法 Cake 和 Pie在同一个包下 所以可以调用
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class Cake {
    public static void main(String[] args) {
        Pie x = new Pie();
        x.f();
    }
}
