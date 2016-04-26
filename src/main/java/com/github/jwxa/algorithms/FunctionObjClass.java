package com.github.jwxa.algorithms;

import java.util.Comparator;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/3/23.
 */
public class FunctionObjClass {

    public static <AnyType> AnyType findMax(AnyType []arr,Comparator<? super AnyType> comparator){
        int maxIndex =0 ;
        for (int i = 0; i < arr.length; i++) {
            if(comparator.compare(arr[i],arr[maxIndex])>0){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
}
class CaseInsensitiveCompare implements Comparator<String>{

    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}

class TestProgram{
    public static void main(String[] args) {
        String [] arr = {"ZEBRA","alligator","crocodile"};
        System.out.println(FunctionObjClass.findMax(arr, new CaseInsensitiveCompare()));
    }
}
