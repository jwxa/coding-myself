package com.github.jwxa.thinkinginjava.chapter5;

/**
 * һ�����й������ļ���
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class SimpleConstructor {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock();
        }
    }
}

class Rock{
    public Rock(){
        System.out.println("Rock ");
    }
}
