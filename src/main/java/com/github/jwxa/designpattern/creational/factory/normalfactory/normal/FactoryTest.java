package com.github.jwxa.designpattern.creational.factory.normalfactory.normal;

/**
 * 总体来说，工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。<br>
 * 在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，我们会选用第三种——静态工厂方法模式。<br>
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
