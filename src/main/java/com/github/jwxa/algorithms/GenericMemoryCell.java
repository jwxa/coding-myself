package com.github.jwxa.algorithms;

/**
 * MemoryCell的泛型实现
 * User: Jwxa
 * Date: 2016/3/23.
 */
public class GenericMemoryCell<AnyType> {
    private AnyType storedValue;

    public AnyType read(){
        return storedValue;
    }

    public void write(AnyType x){
        storedValue = x;
    }


}
