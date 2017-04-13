package com.github.jwxa.jvm.chapter2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助CGLib使方法区出现内存溢出异常
 * VM Args：java8 -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M 元空间
 * VM Args：java7 -XX:PermSize=10M -XX:MaxPermSize=10M 非堆（方法区）
 * User: Jwxa Date: 2017/4/12 ProjectName: coding-myself Version: 1.0
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(objects,args);
                }
            });
            enhancer.create();
        }
    }
    static class OOMObject{

    }
}

