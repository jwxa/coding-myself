package com.github.jwxa.designpattern.behavioral.iterator;

/**
 * 标题<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public interface Iterator {

    //后移
    public Object next();

    public boolean hasNext();

    //前移
    public Object previous();

    //取得第一个元素
    public Object first();

}
