package com.github.jwxa.designpattern.creational.singleton;

import java.io.Serializable;

/**
 * �������̰߳�ȫ<br>
 * ����д���ܹ��ڶ��߳��кܺõĹ��������ҿ�������Ҳ�߱��ܺõ�lazy loading�����ǣ��ź����ǣ�Ч�ʺܵͣ�99%����²���Ҫͬ����
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
