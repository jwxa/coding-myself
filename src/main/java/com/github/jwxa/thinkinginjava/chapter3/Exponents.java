package com.github.jwxa.thinkinginjava.chapter3;

/**
 * 指数计数法
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/10 ProjectName: coding-myself Version: 1.0
 */
public class Exponents {

    public static void main(String[] args) {
        float expFloat = 1.39e-43f;
        expFloat = 1.39E-43f;
        System.out.println(expFloat);
        double expDouble = 47e47d;
        expDouble = 47E47;
        System.out.println(expDouble);
        System.out.println("-------------------------------------------");
        System.out.println(Float.MIN_VALUE);
        System.out.println(1.4e-45f);
        System.out.println(Float.MAX_VALUE);
        System.out.println(3.4028235e38f);
        System.out.println(Double.MIN_VALUE);
        System.out.println(4.9e-324);
        System.out.println(Double.MAX_VALUE);
        System.out.println(1.7976931348623157e308);
    }

}
