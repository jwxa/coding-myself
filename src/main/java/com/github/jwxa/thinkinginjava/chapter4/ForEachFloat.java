package com.github.jwxa.thinkinginjava.chapter4;

import java.util.Random;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/10 ProjectName: coding-myself Version: 1.0
 */
public class ForEachFloat {

    public static void main(String[] args) {
        Random random = new Random(47);
        float f[] = new float[10];
        for (int i = 0; i < 10; i++) {
            f[i] = random.nextFloat();
        }
        for (float v : f) {
            System.out.println(v);
        }
    }
}
