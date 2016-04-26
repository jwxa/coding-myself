package com.github.jwxa.designpattern.creational.abstractfactory;

import com.github.jwxa.designpattern.creational.factory.normalfactory.normal.Sender;
import com.github.jwxa.designpattern.creational.factory.normalfactory.normal.SmsSender;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/4/11.
 */
public class SendSmsFactory implements Provider{
    public Sender produce() {
        return new SmsSender();
    }
}
