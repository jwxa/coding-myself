package com.github.jwxa.thinkinginjava.chapter5;

/**
 * ����ͨ������ĳ���������ṩ��ֵ3 ��������д�Ͳ���
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/24 ProjectName: coding-myself Version: 1.0
 */
public class MethodInit3 {

//    int j = g(i);//"��ǰ����" ���� Illegal forward reference
    int i = f();
    int f(){
        return 11;
    }

    int g(int n){
        return n*10;
    }
}
