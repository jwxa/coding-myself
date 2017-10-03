package com.github.jwxa.guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * http://www.cnblogs.com/peida/p/EventBus.html
 * <p>
 * 方法描述列表
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
     * 说明：在这个方法中,我们看到第一个事件(新的整数(100))是收到两个听众,但第二个(新长(200 l))只能到达NumberListener作为整数一不是创建这种类型的事件。
     * 可以使用此功能来创建更通用的监听器监听一个广泛的事件和更详细的具体的特殊的事件。
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
     * 说明：如果没有消息订阅者监听消息， EventBus将发送DeadEvent消息，这时我们可以通过log的方式来记录这种状态。
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
     * 　只需要在要订阅消息的方法上加上@Subscribe注解即可实现对多个消息的订阅，代码如下：
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
     * 使用Guava之后, 如果要订阅消息, 就不用再继承指定的接口, 只需要在指定的方法上加上@Subscribe注解即可。
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
