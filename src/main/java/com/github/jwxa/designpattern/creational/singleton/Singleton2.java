package com.github.jwxa.designpattern.creational.singleton;

import java.io.Serializable;

/**
 * 懒汉，线程安全<br>
 * 这种写法能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，但是，遗憾的是，效率很低，99%情况下不需要同步。
 * User: Jwxa
 * Date: 2016/4/11.
 */
public class Singleton2 implements Serializable{

    private static Singleton2 instance = null;


    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance(){
        if(instance==null){
                instance = new Singleton2();
        }
        return instance;
    }

    public Object  readResolve(){
        return  instance;
    }
}
