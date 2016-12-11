package com.github.jwxa.thinkinginjava.chapter5;

/**
 * ����Ҫ���ضԵ�ǰ���������ʱ��������return���������д
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class Leaf {
    int i =0;
    Leaf increment(){
        i++;
        return this;
    }

    void print(){
        System.out.println("i="+i);
    }

    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().increment().print();
    }
}
