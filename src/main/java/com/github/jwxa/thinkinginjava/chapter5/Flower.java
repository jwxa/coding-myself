package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 在构造器中调用构造器
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/24 ProjectName: coding-myself Version: 1.0
 */
public class Flower {
    int petalCount = 0;
    String s = "initial value";
    Flower(int petals){
        petalCount = petals;
        System.out.println("Constructor w/ int arg only , petalCount = " + petalCount);

    }

    Flower(String ss){
        System.out.println("Constructor w/ String arg only , s = "+ss);
        s = ss;
    }

    Flower(String s ,int petals){
        this(petals);
        //尽管可以用this调用一个构造器，但却不能调用两个，此外，必须将构造器调用至于最起始处
//        this(s);//Can't call two !
        this.s = s;
        System.out.println("String & int args");
    }

    Flower(){
        this("hi",47);
        System.out.println("default constructor (no args)");
    }

    void printPetalCount(){
        //除构造器之外，编译器禁止在其他任何方法中调用构造器
//        this(11);//Not inside non-constructor
        System.out.println("petalCount = " + petalCount + " , s = " + s);
    }

    public static void main(String[] args) {
        Flower f = new Flower();
        f.printPetalCount();
    }


}
