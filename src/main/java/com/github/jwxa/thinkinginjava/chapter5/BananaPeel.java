package com.github.jwxa.thinkinginjava.chapter5;

/**
 * this 关键字
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana(),b = new Banana();
        //内部的表示形式 实际并不能这么书写
        a.peel(1);
        //内部表示形式为: Banana.peel(a,1)
        b.peel(2);
        //内部表示形式为: Banana.peel(b,2)
    }
}
class Banana{
    void peel(int i){
        System.out.println(i);
    }
}
