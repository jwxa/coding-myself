package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 这个例子同时示范了重载的构造器和重载的方法
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class Overloading {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloading method");
        }
        new Tree();
    }
}
class Tree{
    int height;

    public Tree() {
        System.out.println("planting a seedling");
        height = 0;
    }

    public Tree(int height) {
        this.height = height;
        System.out.println("Creating new Tree that is "+ height + " feet tall");
    }

    void info(){
        System.out.println("Tree is " + height + " feet tall");
    }

    void info(String s){
        System.out.println(s+": Tree is "+ height +" feet tall");
    }
}
