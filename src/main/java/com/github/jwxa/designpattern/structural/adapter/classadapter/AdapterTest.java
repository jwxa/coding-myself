package com.github.jwxa.designpattern.structural.adapter.classadapter;

/**
 * ����
 * User: Jwxa
 * Date: 2016/4/14.
 */
public class AdapterTest {
    /**
     * ����Targetable�ӿڵ�ʵ����;�����Source��Ĺ��ܡ�
     * @param args
     */
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.method1();
        adapter.method2();
    }
}
