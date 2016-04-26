package com.github.jwxa.designpattern.creational.factory.normalfactory.multiple;

import com.github.jwxa.designpattern.creational.factory.normalfactory.normal.Sender;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/4/11.
 */
public class SenderFactoryTest {

    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.produceMail();
        sender.send();
    }
}
