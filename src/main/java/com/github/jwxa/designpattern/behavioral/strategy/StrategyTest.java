package com.github.jwxa.designpattern.behavioral.strategy;

/**
 * ����ģʽ�ľ���Ȩ���û���ϵͳ�����ṩ��ͬ�㷨��ʵ�֣���������ɾ���㷨���Ը����㷨����װ����ˣ�����ģʽ�������㷨����ϵͳ�У��ⲿ�û�ֻ��Ҫ�������ĸ��㷨���ɡ�<br>
 * User: Jwxa<br>
 * Date: 2016/6/13.
 */
public class StrategyTest {

    public static void main(String[] args) {
        ICalculator calculator = new Plus();
        int result = calculator.calculate("1+1");
        System.out.println(result);
    }
}
