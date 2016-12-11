package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 无默认构造器
 * 如果已经定义了一个构造器（无论是否有参数）,编译器就不会帮你自动创建默认构造器
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class NoSynthesis {

    public static void main(String[] args) {
        //!Bird2 b = new Bird2();//无默认构造器
        Bird2 b2 = new Bird2(1);
        Bird2 b3 = new Bird2("test");
    }

}
class Bird2{
    public Bird2(int i) {
    }

    public Bird2(String s) {
    }
}
