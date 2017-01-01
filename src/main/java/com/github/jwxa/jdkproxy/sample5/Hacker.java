package com.github.jwxa.jdkproxy.sample5;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实现了方法拦截器接口
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/1 ProjectName: coding-myself Version: 1.0
 */
public class Hacker implements MethodInterceptor {
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("**** I am a hacker,Let's see what the poor programmer is doing Now...");
        methodProxy.invokeSuper(obj, args);
        System.out.println("****  Oh,what a poor programmer.....");
        return null;
    }
}
