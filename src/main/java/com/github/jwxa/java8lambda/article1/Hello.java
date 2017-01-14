package com.github.jwxa.java8lambda.article1;

/**
 * 相对于内部类，lambda 表达式的语义就十分简单：它不会从超类（supertype）中继承任何变量名，也不会引入一个新的作用域。
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/6 ProjectName: coding-myself Version: 1.0
 */
public class Hello {
    Runnable r1 = ()-> System.out.println(this);

    Runnable r2 = ()-> System.out.println(toString());

    public String toString(){
        return "Hello World";
    }

    public static void main(String[] args) {
        new Hello().r1.run();
        new Hello().r2.run();
    }

}
