package com.github.jwxa.designpattern.behavioral.observer;

/**
 * 标题<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public interface Subject {

    /*添加观察者*/
    public void add(Observer observer);

    /*删除观察者*/
    public void remove(Observer observer);

    /*通知所有观察者*/
    public void notifyObservers();

    /*自身的操作*/
    public void operation();


}
