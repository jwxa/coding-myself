package com.github.jwxa.designpattern.structural.proxy;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/5/10.
 */
public class Proxy implements Sourceable {
    private Source source;

    public Proxy() {
        super();
        this.source = new Source();
    }

    public void method() {
        before();
        source.method();
        after();
    }


    private void before(){
        System.out.println("before proxy");
    }

    private void after(){
        System.out.println("after proxy");
    }
}
