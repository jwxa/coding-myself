package com.github.jwxa.designpattern.behavioral.observer;

/**
 * �۲���ģʽ<br>
 * �ܺ���⣬�������ʼ����ĺ�RSS���ģ����������һЩ���ͻ�wikiʱ�������ῴ��RSSͼ�꣬�������˼�ǣ����㶩���˸����£���������и��£��ἰʱ֪ͨ�㡣<br>
 * ��ʵ����������һ�仰����һ������仯ʱ�����������ö���Ķ��󶼻��յ�֪ͨ���������ű仯��<br>
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
