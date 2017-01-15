package com.github.jwxa.thinkinginjava.chapter6.access;

/**
 * private 关键字
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class IceCream {

    public static void main(String[] args) {
//        Sundae x = new Sundae(); 构造方法使用了 private 关键字
        Sundae x = Sundae.makeASundae();
    }
}
class Sundae{
    private Sundae(){};

    static Sundae makeASundae(){
        return new Sundae();
    }

}