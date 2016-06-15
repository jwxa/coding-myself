package com.github.jwxa.designpattern.behavioral.command;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/6/15.
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}
