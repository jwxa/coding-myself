package com.github.jwxa.algorithms;

/**
 * Integer��װ���һ����ʾ
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
