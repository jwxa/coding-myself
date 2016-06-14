package com.github.jwxa.designpattern.behavioral.iterator;

/**
 * 标题<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public interface Collection {

    public Iterator iterator();

    /*取得集合元素*/
    public Object get(int i);

    /*取得集合大小*/
    public int size();

}
