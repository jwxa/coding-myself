package com.github.jwxa.designpattern.creational.factory.normalfactory.normal;

/**
 * ����
 * User: Jwxa
 * Date: 2016/4/11.
 */
public class SenderFactory {

    public Sender produce(String type){
        if("mail".equals(type)){
            return new MailSender();
        }else if ("sms".equals(type)){
            return new SmsSender();
        }else{
            System.out.println("��������ȷ����");
            return null;
        }
    }

}
