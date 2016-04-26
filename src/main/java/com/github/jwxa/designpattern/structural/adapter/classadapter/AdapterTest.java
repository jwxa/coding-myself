package com.github.jwxa.designpattern.structural.adapter.classadapter;

/**
 * 标题
 * User: Jwxa
 * Date: 2016/4/14.
 */
public class AdapterTest {
    /**
     * 这样Targetable接口的实现类就具有了Source类的功能。
     * @param args
     */
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.method1();
        adapter.method2();
    }
}
