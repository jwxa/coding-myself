package com.github.jwxa.thinkinginjava.chapter5;

import java.util.Arrays;

/**
 * ö����˳��
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class EnumOrder {
    public static void main(String[] args) {
//        for (Spiciness s:Spiciness.values()){
//            System.out.println(s+ ",ordinal "+ s.ordinal());
//        }
        Arrays.stream(Spiciness.values()).forEach(a-> System.out.println(a+",ordinal "+ a.ordinal()));
    }
}
