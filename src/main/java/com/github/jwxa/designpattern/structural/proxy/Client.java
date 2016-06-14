package com.github.jwxa.designpattern.structural.proxy;

/**
 * 代理模式<br>
 *
 * 代理模式的应用场景：<br>

 如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：<br>

 1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。<br>

 2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。<br>

 使用代理模式，可以将功能划分的更加清晰，有助于后期维护！<br>

 * User: Jwxa<br>
 * Date: 2016/5/10.
 */
public class Client {

    public static void main(String[] args) {
        Sourceable sourceable = new Proxy();
        sourceable.method();
    }
}
