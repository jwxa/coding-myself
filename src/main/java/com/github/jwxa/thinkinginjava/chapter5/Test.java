package com.github.jwxa.thinkinginjava.chapter5;

/**
 * a=0 b=1
 * 执行顺序 a=0 b=0 ; a=1 b=1; a=0 b=1<p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/2 ProjectName: coding-myself Version: 1.0
 */
public class Test {

    public static Test1 t = new Test1();
    public static int a = 0;
    public static int b;

    public static void main(String[] args) {
        System.out.println(Test.a);
        System.out.println(Test.b);
    }
}
class  Test1{
    public Test1(){
        Test.a++;
        Test.b++;
    }
}
