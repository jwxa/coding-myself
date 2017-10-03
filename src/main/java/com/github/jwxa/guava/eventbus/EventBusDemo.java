package com.github.jwxa.guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * http://www.cnblogs.com/peida/p/EventBus.html
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/10/3 ProjectName: coding-myself Version: 1.0
 */
public class EventBusDemo {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();

    }

    /**
     * ˵���������������,���ǿ�����һ���¼�(�µ�����(100))���յ���������,���ڶ���(�³�(200 l))ֻ�ܵ���NumberListener��Ϊ����һ���Ǵ����������͵��¼���
     * ����ʹ�ô˹�����������ͨ�õļ���������һ���㷺���¼��͸���ϸ�ľ����������¼���
     */
    private static void test4() {
        EventBus eventBus = new EventBus("test4");
        IntegerListener integerListener = new IntegerListener();
        NumberListener numberListener = new NumberListener();
        eventBus.register(integerListener);
        eventBus.register(numberListener);

        eventBus.post(100);
        System.out.println("integerListener message:"+integerListener.getLastMessage());
        System.out.println("numberListener message:"+numberListener.getLastMessage());

        eventBus.post(new Long(200L));

        System.out.println("integerListener message:"+integerListener.getLastMessage());
        System.out.println("numberListener message:"+numberListener.getLastMessage());
    }

    /**
     * ˵�������û����Ϣ�����߼�����Ϣ�� EventBus������DeadEvent��Ϣ����ʱ���ǿ���ͨ��log�ķ�ʽ����¼����״̬��
     */
    private static void test3() {
        EventBus eventBus = new EventBus("test3");
        DeadEventListener deadEventListener = new DeadEventListener();
//        EventListener eventListener = new EventListener();
        eventBus.register(deadEventListener);
//        eventBus.register(eventListener);

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        System.out.println("deadEvent:" + deadEventListener.isNotDelivered());
    }

    /**
     * ��ֻ��Ҫ��Ҫ������Ϣ�ķ����ϼ���@Subscribeע�⼴��ʵ�ֶԶ����Ϣ�Ķ��ģ��������£�
     */
    private static void test2() {
        EventBus eventBus = new EventBus("test2");
        MultipleListener multiListener = new MultipleListener();
        eventBus.register(multiListener);
        eventBus.post(new Integer(100));
        eventBus.post(new Integer(200));
        eventBus.post(new Integer(300));
        eventBus.post(new Long(800));
        eventBus.post(new Long(800990));
        eventBus.post(new Long(800882934));
        System.out.println("LastInteger:" + multiListener.getLastInteger());
        System.out.println("LastLong:" + multiListener.getLastLong());
    }

    /**
     * ʹ��Guava֮��, ���Ҫ������Ϣ, �Ͳ����ټ̳�ָ���Ľӿ�, ֻ��Ҫ��ָ���ķ����ϼ���@Subscribeע�⼴�ɡ�
     */
    private static void test1() {
        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();
        eventBus.register(listener);
        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));
        System.out.println("LastMessage:" + listener.getLastMessage());
    }
}
