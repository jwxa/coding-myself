package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 可变参数列表变为数组的情形
 * 不依赖于自动包装机制
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/3 ProjectName: coding-myself Version: 1.0
 */
public class VarargType {
    static void f(Character ... args){
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }
    static void g(int ... args){
        System.out.print(args.getClass());
        System.out.println(" length "+ args.length);
    }

    public static void main(String[] args) {
        f('a');
        f();
        g(1);
        g();
        System.out.println("int[]:"+ new int[0].getClass());
    }
}
