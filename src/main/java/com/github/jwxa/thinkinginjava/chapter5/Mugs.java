package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 非静态实例初始化
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/2 ProjectName: coding-myself Version: 1.0
 */
public class Mugs {
    Mug mug1;
    Mug mug2;

    {
        mug1=new Mug(1);
        mug2=new Mug(2);
    }
    Mugs(){
        System.out.println("Mugs()");
    }
    Mugs(int i){
        System.out.println("Mugs(int)");
    }

    public static void main(String[] args) {
        System.out.println("Inside main()");
        new Mugs();//mug1 mug2  Mugs()
        System.out.println("new Mugs completed");
        new Mugs(1);//mug1 mug2 Mugs(int)
        System.out.println("new Mugs(1) completed");
    }


}

class Mug{
    Mug(int marker){
        System.out.println("Mug("+marker+")");
    }

    void f(int marker){
        System.out.println("f("+marker+")");
    }
}
