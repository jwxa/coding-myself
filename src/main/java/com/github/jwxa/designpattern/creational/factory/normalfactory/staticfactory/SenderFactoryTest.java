package com.github.jwxa.designpattern.creational.factory.normalfactory.staticfactory;

import com.github.jwxa.designpattern.creational.factory.normalfactory.normal.Sender;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/4/11.
 */
public class SenderFactoryTest {

    public static void main(String[] args) {
        Sender sender =  SenderFactory.produceMail();
        sender.send();
    }
}
