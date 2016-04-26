package com.github.jwxa.designpattern.creational.abstractfactory;

import com.github.jwxa.designpattern.creational.factory.normalfactory.normal.Sender;

/**
 * ���󹤳�ģʽ<br>
 * ��ʵ���ģʽ�ĺô����ǣ����������������һ�����ܣ�<br>
 * ����ʱ��Ϣ����ֻ����һ��ʵ���࣬ʵ��Sender�ӿڣ�ͬʱ��һ�������࣬ʵ��Provider�ӿڣ���OK�ˣ�<br>
 * ����ȥ�Ķ��ֳɵĴ��롣����������չ�ԽϺã�<br>
 * User: Jwxa<br>
 * Date: 2016/4/11.
 */
public class Test {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
