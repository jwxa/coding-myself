package com.github.jwxa.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * ������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/10/3 ProjectName: coding-myself Version: 1.0
 */
public class IntegerListener {

    private Integer lastMessage;

    @Subscribe
    public void listen(Integer integer) {
        lastMessage = integer;
        System.out.println("Message:"+lastMessage);
    }

    public Integer getLastMessage() {
        return lastMessage;
    }
}
