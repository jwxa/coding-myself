package com.github.jwxa.thinkinginjava.chapter5;

/**
 * ��Ĭ�Ϲ�����
 * ����Ѿ�������һ���������������Ƿ��в�����,�������Ͳ�������Զ�����Ĭ�Ϲ�����
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class NoSynthesis {

    public static void main(String[] args) {
        //!Bird2 b = new Bird2();//��Ĭ�Ϲ�����
        Bird2 b2 = new Bird2(1);
        Bird2 b3 = new Bird2("test");
    }

}
class Bird2{
    public Bird2(int i) {
    }

    public Bird2(String s) {
    }
}
