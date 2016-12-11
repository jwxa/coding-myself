package com.github.jwxa.thinkinginjava.chapter5;

/**
 * this�ؼ��� ����ǰ���󴫵ݸ���������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }


}
class Person{
    public void eat(Apple apple){
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}
class Peeler{
    static Apple peel(Apple apple){
        //...remove peel
        return apple;
    }
}
class Apple{
    Apple getPeeled(){
        return Peeler.peel(this);
    }
}

