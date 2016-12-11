package com.github.jwxa.thinkinginjava.chapter4;

import java.util.Random;

/**
 * switch��� ���������ĸ���ж�������Ԫ�����Ǹ���
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class VowelsAndConsonants {

    public static void main(String[] args) {
        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = random.nextInt(26) + 'a';
            System.out.println((char)c + ", " + c + ": " );
            switch (c){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("vowel");
                    break;
                case 'y':
                case 'w':
                    System.out.println("Sometimes a vowel");
                    break;
                    default:
                        System.out.println("consonant");
            }
        }
    }
}
