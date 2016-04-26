package com.github.jwxa.designpattern.creational.singleton;

import java.io.Serializable;

/**
 * �������̲߳���ȫ<br>
 * ����д��lazy loading�����ԣ��������������ڶ��̲߳�������������
 * User: Jwxa
 * Date: 2016/4/11.
 */
public class Singleton implements Serializable{

    /* ����˽�о�̬ʵ������ֹ�����ã��˴���ֵΪnull��Ŀ����ʵ���ӳټ��� */
    private static Singleton instance = null;

    /* ˽�й��췽������ֹ��ʵ���� */
    private Singleton() {
    }

    /* ��̬���̷���������ʵ�� */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */
    public Object readResolve() {
        return instance;
    }

}
