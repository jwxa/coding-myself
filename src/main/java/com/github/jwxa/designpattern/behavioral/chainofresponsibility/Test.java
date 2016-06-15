package com.github.jwxa.designpattern.behavioral.chainofresponsibility;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public class Test {

    public static void main(String[] args) {
        MyHandler myHandler1 = new MyHandler("h1");
        MyHandler myHandler2 = new MyHandler("h2");
        MyHandler myHandler3 = new MyHandler("h3");
        myHandler1.setHandler(myHandler2);
        myHandler2.setHandler(myHandler3);
        myHandler1.operation();
    }
}
