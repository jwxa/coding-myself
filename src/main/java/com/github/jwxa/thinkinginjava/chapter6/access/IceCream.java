package com.github.jwxa.thinkinginjava.chapter6.access;

/**
 * private �ؼ���
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class IceCream {

    public static void main(String[] args) {
//        Sundae x = new Sundae(); ���췽��ʹ���� private �ؼ���
        Sundae x = Sundae.makeASundae();
    }
}
class Sundae{
    private Sundae(){};

    static Sundae makeASundae(){
        return new Sundae();
    }

}