package com.github.jwxa.thinkinginjava.chapter4;

/**
 * ���Ų�����
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/10 ProjectName: coding-myself Version: 1.0
 */
public class CommaOperator {

    public static void main(String[] args) {
        for(int i = 1,j=i+10;i<5;i++,j=i*2){
            System.out.println("i="+i +",j="+j);
        }
    }
}
