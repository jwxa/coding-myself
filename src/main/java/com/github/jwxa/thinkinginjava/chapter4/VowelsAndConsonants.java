package com.github.jwxa.thinkinginjava.chapter4;

import java.util.Random;

/**
 * switch语句 随机生成字母，判断他们是元音还是辅音
 * <p>
 * 方法描述列表
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
