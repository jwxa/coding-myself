package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class Practice5 {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.bark(1);
        d.bark(1d);
        d.bark(1L);
    }
}

class Dog{
    void bark(int i){
        System.out.println("barking");
    }

    void bark(long i){
        System.out.println("howling");
    }

    void bark(double i){
        System.out.println("~~~~~~woof");
    }

}
