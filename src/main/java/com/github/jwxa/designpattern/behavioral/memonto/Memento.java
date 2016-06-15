package com.github.jwxa.designpattern.behavioral.memonto;

/**
 * ±¸ÍüÂ¼Àà<br>
 * User: Jwxa<br>
 * Date: 2016/6/15.
 */
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
