package com.github.jwxa.thinkinginjava.chapter6.access;

import com.github.jwxa.thinkinginjava.chapter6.access.dessert.Cookie;

/**
 * 包访问权限
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class ChocolateChip extends Cookie {
    public ChocolateChip() {
        System.out.println("ChocolateChip constructor");
    }

    public void chomp(){
//        bite();//Can't access bite
    }

    public static void main(String[] args) {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
    }
}
