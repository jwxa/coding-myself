package com.github.jwxa.designpattern.structural.adapter.objectadapter;

import com.github.jwxa.designpattern.structural.adapter.classadapter.Source;
import com.github.jwxa.designpattern.structural.adapter.classadapter.Targetable;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/4/14.
 */
public class Wrapper implements Targetable {
    private Source source;

    public void method1() {
        source.method1();
    }

    public void method2() {
        System.out.println("this is the targetable method!");
    }

    public Wrapper(Source source) {
        this.source = source;
    }
}
