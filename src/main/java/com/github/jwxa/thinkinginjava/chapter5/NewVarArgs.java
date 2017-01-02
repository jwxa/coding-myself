package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 可变参数列表 使用增强for循环
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/3 ProjectName: coding-myself Version: 1.0
 */
public class NewVarArgs {

    static void printArray(Object... args){
        for (Object arg : args) {
            System.out.print(arg+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(new Integer(47),
                new Float(3.14),
                new Double(11.11));
        printArray(47,3.14F,11.11);
        printArray("one","two","three");
        printArray(new A(),new A(),new A());
        printArray((Object[])new Integer[]{1,2,3,4});
        printArray();//empty list is ok
    }
}

