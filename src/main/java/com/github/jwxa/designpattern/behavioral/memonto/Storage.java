package com.github.jwxa.designpattern.behavioral.memonto;

/**
 * �洢����¼����<br>
 * User: Jwxa<br>
 * Date: 2016/6/15.
 */
public class Storage {

    private Memento memento;


    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
