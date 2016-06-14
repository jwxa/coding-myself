package com.github.jwxa.designpattern.behavioral.observer;

import java.util.Vector;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public abstract class AbstractSubject implements Subject{

    private Vector<Observer> vector = new Vector<Observer>();

    public void add(Observer observer) {
        vector.add(observer);
    }

    public void remove(Observer observer) {
        vector.remove(observer);
    }

    public void notifyObservers() {
        for(Observer observer:vector){
            observer.update();
        }
    }

}
