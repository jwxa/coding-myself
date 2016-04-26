package com.github.jwxa.designpattern.creational.prototype;

/**
 * 原型类
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 * User: Jwxa
 * Date: 2016/4/13.
 */
public class Prototype implements Cloneable {

    public Object clone() throws CloneNotSupportedException {
        Prototype prototype  = (Prototype) super.clone();
        return prototype;
    }


}
