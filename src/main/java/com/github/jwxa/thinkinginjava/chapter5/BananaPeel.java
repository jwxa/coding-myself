package com.github.jwxa.thinkinginjava.chapter5;

/**
 * this �ؼ���
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana(),b = new Banana();
        //�ڲ��ı�ʾ��ʽ ʵ�ʲ�������ô��д
        a.peel(1);
        //�ڲ���ʾ��ʽΪ: Banana.peel(a,1)
        b.peel(2);
        //�ڲ���ʾ��ʽΪ: Banana.peel(b,2)
    }
}
class Banana{
    void peel(int i){
        System.out.println(i);
    }
}
