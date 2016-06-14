package com.github.jwxa.designpattern.behavioral.observer;

/**
 * 观察者模式<br>
 * 很好理解，类似于邮件订阅和RSS订阅，当我们浏览一些博客或wiki时，经常会看到RSS图标，就这的意思是，当你订阅了该文章，如果后续有更新，会及时通知你。<br>
 * 其实，简单来讲就一句话：当一个对象变化时，其它依赖该对象的对象都会收到通知，并且随着变化！<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new MySubject();
        subject.operation();
        System.out.println("--------------------------------------------");
        subject.add(new Observer1());
        subject.add(new Observer2());
        subject.operation();
    }

}
