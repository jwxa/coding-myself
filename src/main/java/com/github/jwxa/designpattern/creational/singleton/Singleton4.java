package com.github.jwxa.designpattern.creational.singleton;

/**
 * ����������
 *  �����Ͽ��������ͦ����ʵ�������ַ�ʽ��࣬���������ʼ����ʵ����instance��
 * User: Jwxa
 * Date: 2016/4/12.
 */
public class Singleton4 {

    private static Singleton4 instance = null;

    static {
        instance = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance(){
        return  instance;
    }
}
