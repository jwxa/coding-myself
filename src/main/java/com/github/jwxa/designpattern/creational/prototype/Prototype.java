package com.github.jwxa.designpattern.creational.prototype;

/**
 * ԭ����
 * ǳ���ƣ���һ�������ƺ󣬻����������͵ı����������´��������������ͣ�ָ��Ļ���ԭ������ָ��ġ�
 * User: Jwxa
 * Date: 2016/4/13.
 */
public class Prototype implements Cloneable {

    public Object clone() throws CloneNotSupportedException {
        Prototype prototype  = (Prototype) super.clone();
        return prototype;
    }


}
