package com.github.jwxa.thinkinginjava.chapter5;

/**
 * ����ͨ������ĳ���������ṩ��ֵ2 ����Ҳ���Դ��в���
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/24 ProjectName: coding-myself Version: 1.0
 */
public class MethodInit2 {
    int i =f();
    int j =g(i);
    int f(){
        return 11;
    }
    int g(int n){
        return n*10;
    }
}
