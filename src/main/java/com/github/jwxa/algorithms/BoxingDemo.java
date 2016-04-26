package com.github.jwxa.algorithms;

/**
 * ×Ô¶¯²ð×°Ïä
 * User: Jwxa
 * Date: 2016/3/23.
 */
public class BoxingDemo {


    public static void main(String[] args) {
        GenericMemoryCell<Integer> genericMemoryCell = new GenericMemoryCell<Integer>();
        genericMemoryCell.write(1);
        int val = genericMemoryCell.read();
        System.out.println(val);
    }
}
