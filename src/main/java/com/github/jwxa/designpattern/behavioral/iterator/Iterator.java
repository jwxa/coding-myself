package com.github.jwxa.designpattern.behavioral.iterator;

/**
 * ����<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public interface Iterator {

    //����
    public Object next();

    public boolean hasNext();

    //ǰ��
    public Object previous();

    //ȡ�õ�һ��Ԫ��
    public Object first();

}
