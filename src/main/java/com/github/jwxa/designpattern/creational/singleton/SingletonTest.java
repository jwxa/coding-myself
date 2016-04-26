package com.github.jwxa.designpattern.creational.singleton;

import java.util.Vector;

/**
 * Ó°×ÓÊµÀý
 * User: Jwxa
 * Date: 2016/4/12.
 */
public class SingletonTest {

    private static SingletonTest instance = null;

    private Vector properties = null;

    public Vector getProperties(){
        return  properties;
    }

    private SingletonTest(){}

    private static  synchronized  void syncInit (){
        if(instance == null){
            instance = new SingletonTest();
        }
    }

    public static SingletonTest getInstance(){
        if(instance==null){
            syncInit();
        }
        return instance;
    }

    public void updateProperties(){
        SingletonTest shadow = new SingletonTest();
        properties = shadow.getProperties();
    }
}
