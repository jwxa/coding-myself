package com.github.jwxa.designpattern.structural.adapter.classadapter;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/4/14.
 */
public class Adapter extends Source implements Targetable{
    public void method2() {
        System.out.println("this is the targetable method");
    }
}
