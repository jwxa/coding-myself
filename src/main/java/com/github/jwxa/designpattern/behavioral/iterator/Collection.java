package com.github.jwxa.designpattern.behavioral.iterator;

/**
 * ����<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public interface Collection {

    public Iterator iterator();

    /*ȡ�ü���Ԫ��*/
    public Object get(int i);

    /*ȡ�ü��ϴ�С*/
    public int size();

}
