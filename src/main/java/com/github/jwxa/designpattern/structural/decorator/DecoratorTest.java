package com.github.jwxa.designpattern.structural.decorator;

/**
 * װ��ģʽ<br>
 * װ����ģʽ��Ӧ�ó�����<br>

 1����Ҫ��չһ����Ĺ��ܡ�<br>

 2����̬��Ϊһ���������ӹ��ܣ����һ��ܶ�̬���������̳в���������һ�㣬�̳еĹ����Ǿ�̬�ģ����ܶ�̬��ɾ����<br>

 ȱ�㣺�����������ƵĶ��󣬲����Ŵ�<br>

 * User: Jwxa<br>
 * Date: 2016/5/10.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Source source = new Source();
        Sourceable sourceable = new Decorator(source);
        sourceable.method();
    }
}
