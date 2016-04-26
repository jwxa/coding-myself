package com.github.jwxa.designpattern.creational.factory.normalfactory.staticfactory;

import com.github.jwxa.designpattern.creational.factory.normalfactory.normal.MailSender;
import com.github.jwxa.designpattern.creational.factory.normalfactory.normal.Sender;
import com.github.jwxa.designpattern.creational.factory.normalfactory.normal.SmsSender;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/4/11.
 */
public class SenderFactory {

    public static Sender produceMail(){
        return  new MailSender();
    }

    public static Sender produceSms(){
        return  new SmsSender();
    }
}
