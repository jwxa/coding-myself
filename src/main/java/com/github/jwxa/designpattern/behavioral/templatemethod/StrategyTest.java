package com.github.jwxa.designpattern.behavioral.templatemethod;

/**
 * ����һ��ģ�巽��ģʽ������ָ��һ���������У���һ�����������ٶ���1...n�������������ǳ���ģ�Ҳ������ʵ�ʵķ���������һ���࣬�̳иó����࣬��д���󷽷���ͨ�����ó����࣬ʵ�ֶ�����ĵ���<br>
 * User: Jwxa<br>
 * Date: 2016/6/13.
 */
public class StrategyTest {

    public static void main(String[] args) {
        String exp   = "8+8";
        AbstractCalculator abstractCalculator = new Plus();
        System.out.println(abstractCalculator.calulate(exp,"\\+"));
    }

}
