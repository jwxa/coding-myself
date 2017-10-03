package com.github.jwxa.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/10/3 ProjectName: coding-myself Version: 1.0
 */
public class NumberListener {

    private Number lastMessage;

    @Subscribe
    public void listen(Number integer) {
        lastMessage = integer;
        System.out.println("Message:"+lastMessage);
    }

    public Number getLastMessage() {
        return lastMessage;
    }
}
