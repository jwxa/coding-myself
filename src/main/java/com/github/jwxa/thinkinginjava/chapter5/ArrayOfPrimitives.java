package com.github.jwxa.thinkinginjava.chapter5;

/**
 * ���� ��������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/2 ProjectName: coding-myself Version: 1.0
 */
public class ArrayOfPrimitives {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;
        for (int i = 0; i < a2.length; i++) {
            a2[i] = a2[i]+1;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]);
        }
    }
}
