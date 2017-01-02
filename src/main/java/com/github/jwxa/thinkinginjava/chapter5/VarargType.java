package com.github.jwxa.thinkinginjava.chapter5;

/**
 * �ɱ�����б��Ϊ���������
 * ���������Զ���װ����
 * <p>
 * ���������б�
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
