package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 初始化顺序
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/24 ProjectName: coding-myself Version: 1.0
 */
public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();//w1 w2 w3 house() w33 f()
        h.f();
    }

}
class Window{
    Window(int marker){
        System.out.println("Window{"+marker+"}");
    }
}
class House{
    Window w1 = new Window(1);
    House(){
        System.out.println("House()");
        w3=new Window(33);
    }
    Window w2 = new Window(2);
    void f(){
        System.out.println("f()");
    }
    Window w3 = new Window(3);
}