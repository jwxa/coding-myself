package com.github.jwxa.designpattern.structural.bridge;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/5/31.
 */
public class MyBridge extends Bridge {
    public void method() {
        getSource().method();
    }
}
