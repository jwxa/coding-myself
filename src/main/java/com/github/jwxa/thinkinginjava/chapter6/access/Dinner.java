package com.github.jwxa.thinkinginjava.chapter6.access;

import com.github.jwxa.thinkinginjava.chapter6.access.dessert.Cookie;

/**
 * 默认包方法 Dinner和Cookie不在同一个包下  所以无法调用
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class Dinner {
    public static void main(String[] args) {
        Cookie x =new Cookie();
//        x.bite(); 默认包方法 所以无法调用
    }
}
