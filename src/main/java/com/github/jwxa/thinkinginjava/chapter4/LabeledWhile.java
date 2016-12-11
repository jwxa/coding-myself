package com.github.jwxa.thinkinginjava.chapter4;

/**
 * 带标签的break以及continue语句在while循环中的用法
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class LabeledWhile {
    public static void main(String[] args) {
        int i =0;
        outer:
        while(true){
            System.out.println("outer while loop");
            while(true){
                i++;
                System.out.println("i="+i);
                if(i==1){
                    System.out.println("continue");
                    continue ;
                }
                if(i==3){
                    System.out.println("continue outer");
                    continue outer;
                }
                if(i==5){
                    System.out.println("break");
                    break ;
                }
                if(i==7){
                    System.out.println("break outer");
                    break outer;
                }
            }

        }
    }
}
