package com.github.jwxa.designpattern.behavioral.state;

/**
 * 状态模式的切换类<br>
 * User: Jwxa<br>
 * Date: 2016/6/15.
 */
public class Context {

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Context(State state) {
        this.state = state;
    }

    public void method(){
        if(state.getValue().equals("state1")){
            state.method1();
        }else if(state.getValue().equals("state2")){
            state.method2();
        }
    }
}
