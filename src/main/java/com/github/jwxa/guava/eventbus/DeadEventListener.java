package com.github.jwxa.guava.eventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * ������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/10/3 ProjectName: coding-myself Version: 1.0
 */
public class DeadEventListener {
    boolean notDelivered = false;

    @Subscribe
    public void listen(DeadEvent event) {

        notDelivered = true;
    }

    public boolean isNotDelivered() {
        return notDelivered;
    }
}