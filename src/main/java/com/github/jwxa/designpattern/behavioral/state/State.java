package com.github.jwxa.designpattern.behavioral.state;

/**
 * 状态类的核心类 <br>
 * User: Jwxa<br>
 * Date: 2016/6/15.
 */
public class State {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public void method1(){
        System.out.println("execute method1");
    }

    public void method2(){
        System.out.println("execute method2");
    }
}
