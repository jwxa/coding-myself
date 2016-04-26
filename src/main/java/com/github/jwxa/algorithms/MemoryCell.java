package com.github.jwxa.algorithms;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/3/23.
 */
public class MemoryCell {

    private Object storedValue;

    public Object read(){
        return storedValue;
    }

    public void write(Object x){
        storedValue = x;
    }

}
