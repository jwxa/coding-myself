package com.github.jwxa.thinkinginjava.chapter4;

/**
 * 标签用于for循环的例子
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class LabeledFor {

    public static void main(String[] args) {
        int i =0;
        outer:
        for(;true;){
            inner:
            for(;i<10;i++){
                System.out.println("i= "+i);
                if(i==2){
                    System.out.println("continue");
                    continue ;
                }
                if(i==3){
                    System.out.println("break");
                    i++;//不加则i一直是3 死循环
                    break ;
                }
                if(i==7){
                    System.out.println("continue outer");
                    i++;//不加则i一直是7 死循环
                    continue outer;
                }
                if(i==8){
                    System.out.println("break outer");
                    break outer;
                }
                for(int k=0;k<5;k++){
                    if(k==3){
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
}
