package com.github.jwxa.designpattern.behavioral.observer;

/**
 * ����<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public interface Subject {

    /*��ӹ۲���*/
    public void add(Observer observer);

    /*ɾ���۲���*/
    public void remove(Observer observer);

    /*֪ͨ���й۲���*/
    public void notifyObservers();

    /*����Ĳ���*/
    public void operation();


}
