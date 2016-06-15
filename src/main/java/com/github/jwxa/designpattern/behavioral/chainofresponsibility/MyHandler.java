package com.github.jwxa.designpattern.behavioral.chainofresponsibility;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public class MyHandler extends AbstractHandler implements Handler{

    private String name;

    public MyHandler(String name){
        this.name = name;
    }

    public void operation() {
        System.out.println(name + "deal!");
        if(getHandler()!=null){
            getHandler().operation();
        }
    }
}
