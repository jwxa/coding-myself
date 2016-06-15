package com.github.jwxa.designpattern.behavioral.command;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/6/15.
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void exe() {
        receiver.action();
    }
}
