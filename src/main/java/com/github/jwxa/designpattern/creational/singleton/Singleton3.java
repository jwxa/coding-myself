package com.github.jwxa.designpattern.creational.singleton;

import java.io.Serializable;

/**
 * ����<br>
 *  ���ַ�ʽ����classloder���Ʊ����˶��̵߳�ͬ�����⣬
 *  ������instance����װ��ʱ��ʵ��������Ȼ������װ�ص�ԭ���кܶ��֣��ڵ���ģʽ�д�������ǵ���getInstance������
 *  ����Ҳ����ȷ���������ķ�ʽ�����������ľ�̬������������װ�أ���ʱ���ʼ��instance��Ȼû�дﵽlazy loading��Ч����
 * User: Jwxa
 * Date: 2016/4/11.
 */
public class Singleton3 implements Serializable{

    private static Singleton3 instance = new Singleton3();

    public static Singleton3 getInstance(){
        return instance;
    }

    private Singleton3() {
    }

    public Object readResolve(){
        return instance;
    }


}
