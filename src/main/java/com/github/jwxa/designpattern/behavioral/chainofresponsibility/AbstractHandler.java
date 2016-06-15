package com.github.jwxa.designpattern.behavioral.chainofresponsibility;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public abstract class AbstractHandler {
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
