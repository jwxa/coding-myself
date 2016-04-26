package com.github.jwxa.algorithms;

/**
 * Integer包装类的一种演示
 * User: Jwxa
 * Date: 2016/3/23.
 */
public class WrapperDemo {

    public static void main(String[] args) {
        MemoryCell m = new MemoryCell();
        m.write(new Integer(37));
        Integer wrapperVal = (Integer) m.read();
        int val = wrapperVal.intValue();
        System.out.println("Contents are"+ val);
    }
}
