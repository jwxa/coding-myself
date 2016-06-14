package com.github.jwxa.designpattern.structural.decorator;

/**
 * 装饰模式<br>
 * 装饰器模式的应用场景：<br>

 1、需要扩展一个类的功能。<br>

 2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）<br>

 缺点：产生过多相似的对象，不易排错！<br>

 * User: Jwxa<br>
 * Date: 2016/5/10.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Source source = new Source();
        Sourceable sourceable = new Decorator(source);
        sourceable.method();
    }
}
