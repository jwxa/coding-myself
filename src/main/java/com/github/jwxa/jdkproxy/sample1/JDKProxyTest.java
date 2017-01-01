package com.github.jwxa.jdkproxy.sample1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * https://my.oschina.net/robinyao/blog/811193
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/29 ProjectName: coding-myself Version: 1.0
 */
public class JDKProxyTest {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class<?> proxyClass = Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(),Helloworld.class);
        final Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        final InvocationHandler ih = new MyInvocationHandler(new HelloworldImpl());
        Helloworld helloworld = (Helloworld) constructor.newInstance(ih);
        helloworld.sayHello();

        //�����Ǹ��򵥵�һ��д���������Ϻ�������һ����
        /*
        HelloWorld helloWorld=(HelloWorld)Proxy.
                 newProxyInstance(JDKProxyTest.class.getClassLoader(),
                        new Class<?>[]{HelloWorld.class},
                        new MyInvocationHandler(new HelloworldImpl()));
        helloWorld.sayHello();
        */
    }

}
