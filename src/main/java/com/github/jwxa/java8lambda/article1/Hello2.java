package com.github.jwxa.java8lambda.article1;

/**
 * 在内部类中使用变量名（以及 this）非常容易出错。内部类中通过继承得到的成员（包括来自 Object 的方法）可能会把外部类的成员掩盖（shadow），此外未限定（unqualified）的 this 引用会指向内部类自己而非外部类。
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/6 ProjectName: coding-myself Version: 1.0
 */
public class Hello2 {


    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println(toString());
        }
    };

    public String toString(){
        return "Hello World";
    }

    public static void main(String[] args) {
        new Hello2().r1.run();
        new Hello2().r2.run();
    }
}
