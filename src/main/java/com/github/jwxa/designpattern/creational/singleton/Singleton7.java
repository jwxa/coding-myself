package com.github.jwxa.designpattern.creational.singleton;

/**
 * ˫��У����<br>
 * http://www.race604.com/java-double-checked-singleton/?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 * User: Jwxa
 * Date: 2016/4/12.
 */
public class Singleton7 {
    /**
     * ����ʹ����volatile
     */
    private volatile static Singleton7 instance = null;

    private Singleton7 (){}

    public static Singleton7 getInstance(){
        if(instance==null){
            synchronized (Singleton7.class) {
                if(instance==null){
                    instance = new Singleton7();
                }
            }
        }
        return instance;
    }



}
