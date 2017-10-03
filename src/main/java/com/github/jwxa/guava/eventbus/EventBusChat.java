package com.github.jwxa.guava.eventbus;

import com.google.common.eventbus.EventBus;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/10/3 ProjectName: coding-myself Version: 1.0
 */
public class EventBusChat {
    public static void main(String[] args) {
        EventBus channel = new EventBus();
        ServerSocket socket;
        try {
            socket = new ServerSocket(4444);
            while (true) {
                Socket connection = socket.accept();
                UserThread newUser = new UserThread(connection, channel);
                channel.register(newUser);
                newUser.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
