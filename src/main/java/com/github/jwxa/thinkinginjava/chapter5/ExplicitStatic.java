package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 静态块
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/2 ProjectName: coding-myself Version: 1.0
 */
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99);
    }

//    static Cups cups1 = new Cups();
//    static Cups cups2 = new Cups();


}
class Cup{
    Cup(int marker){
        System.out.println("Cup("+marker+")");
    }

    void f(int marker){
        System.out.println("f("+marker+")");
    }


}
class Cups{
    static Cup cup1 ;
    static Cup cup2;

    static {
        cup1=new Cup(1);
        cup2=new Cup(2);
    }
    Cups(){
        System.out.println("Cups()");
    }
}
