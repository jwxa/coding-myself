package com.github.jwxa.designpattern.structural.bridge;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/5/31.
 */
public abstract  class Bridge {
    private Sourceable source;

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }

    public void method(){
        source.method();
    }
}
