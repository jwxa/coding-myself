package com.github.jwxa.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/10/3 ProjectName: coding-myself Version: 1.0
 */
public class MultipleListener {
    public Integer lastInteger;
    public Long lastLong;

    @Subscribe
    public void listenInteger(Integer event) {
        lastInteger = event;
        System.out.println("event Integer:"+lastInteger);
    }

    @Subscribe
    public void listenLong(Long event) {
        lastLong = event;
        System.out.println("event Long:"+lastLong);
    }

    public Integer getLastInteger() {
        return lastInteger;
    }

    public Long getLastLong() {
        return lastLong;
    }
}