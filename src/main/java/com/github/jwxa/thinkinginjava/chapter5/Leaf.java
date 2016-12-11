package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 当需要返回对当前对象的引用时，常常在return语句里这样写
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class Leaf {
    int i =0;
    Leaf increment(){
        i++;
        return this;
    }

    void print(){
        System.out.println("i="+i);
    }

    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().increment().print();
    }
}
