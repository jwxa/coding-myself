package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 可变参数列表
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/3 ProjectName: coding-myself Version: 1.0
 */
public class VarArgs {

    static void printArray(Object[] args){
        for (Object arg : args) {
            System.out.println(arg+" ");
        }
    }

    public static void main(String[] args) {
        printArray(new Object[]{
                new Integer(47),
                new Float(3.14),
                new Double(11.11)
        });
        printArray(new Object[]{"one","two","three"});
        printArray(new Object[]{new A(),new A(),new A()});
    }

}
