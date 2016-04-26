package com.github.jwxa.designpattern.creational.factory.normalfactory.normal;

/**
 * ������˵������ģʽ�ʺϣ����ǳ����˴����Ĳ�Ʒ��Ҫ���������Ҿ��й�ͬ�Ľӿ�ʱ������ͨ����������ģʽ���д�����<br>
 * �����ϵ�����ģʽ�У���һ�����������ַ������󣬲�����ȷ�������󣬵���������ڵڶ��֣�����Ҫʵ���������࣬���ԣ����������£����ǻ�ѡ�õ����֡�����̬��������ģʽ��<br>
 * User: Jwxa<br>
 * Date: 2016/4/11.
 */
public class FactoryTest {

    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.produce("sms");
        sender.send();
    }
}
