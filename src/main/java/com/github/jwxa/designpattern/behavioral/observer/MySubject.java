package com.github.jwxa.designpattern.behavioral.observer;

/**
 * ����<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public class MySubject extends AbstractSubject{

    public void operation() {
        System.out.println("update myself");
        notifyObservers();
    }
}
