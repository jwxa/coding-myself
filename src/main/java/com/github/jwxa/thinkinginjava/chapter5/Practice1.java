package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class Practice1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.getString()==null);
    }
}
class A{
    private String string;

    public String getString() {
        return string;
    }
}
