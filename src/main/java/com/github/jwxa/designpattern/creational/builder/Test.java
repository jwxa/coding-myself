package com.github.jwxa.designpattern.creational.builder;

/**
 * 建造者模式测试类
 * User: Jwxa
 * Date: 2016/4/13.
 */
public class Test {

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }

}
