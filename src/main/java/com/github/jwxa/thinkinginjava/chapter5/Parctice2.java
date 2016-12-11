package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class Parctice2 {
    public static void main(String[] args) {
        A2 a2 = new A2("test2");

    }
}
class A2{
    private String string1 = "test";

    private String string2;

    public String getString() {
        return string1;
    }

    public A2(String string2) {
        this.string2 = string2;
    }
}