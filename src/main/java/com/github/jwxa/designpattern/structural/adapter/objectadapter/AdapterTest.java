package com.github.jwxa.designpattern.structural.adapter.objectadapter;

import com.github.jwxa.designpattern.structural.adapter.classadapter.Source;
import com.github.jwxa.designpattern.structural.adapter.classadapter.Targetable;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/4/14.
 */
public class AdapterTest {

    public static void main(String[] args) {
        Source source = new Source();
        Targetable wrapper = new Wrapper(source);
        wrapper.method1();
    }

}
