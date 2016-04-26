package com.github.jwxa.designpattern.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者类
 * User: Jwxa
 * Date: 2016/4/12.
 */
public class Builder {


    private List<ISender> list = new ArrayList<ISender>();

    public void produceMailSender(int count){
        for(int i = 0 ;i <count ;i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i = 0 ;i <count ;i++){
            list.add(new SmsSender());
        }
    }

}
