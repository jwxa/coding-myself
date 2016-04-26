package com.github.jwxa.algorithms;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/3/23.
 */
public class AnyTypeExtendsClass {

    public static <AnyType extends Comparable<? super AnyType>> AnyType findMax(AnyType [] arr){
        int maxIndex =0 ;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(arr[maxIndex])>0)
                maxIndex = i;
        }
        return arr[maxIndex];
    }

    public static void main(String[] args) {
        GenericMemoryCell<Integer> cell1 = new GenericMemoryCell<Integer>();
        cell1.write(4);
        Object cell = cell1;
        GenericMemoryCell<String> cell2 = (GenericMemoryCell<String>) cell;
        String s = cell2.read();
        System.out.println(s);
    }

}
