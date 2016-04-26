package com.github.jwxa.designpattern.structural.adapter.interfaceadapter;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/4/14.
 */
public class WrapperTest {

    public static void main(String[] args) {
        Sourceable sourceable1 = new SourceSub1();
        sourceable1.method1();
        Sourceable sourceable2 = new SourceSub2();
        sourceable2.method2();
    }
}
