package com.github.jwxa.jdkproxy.sample1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/29 ProjectName: coding-myself Version: 1.0
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method :"+ method.getName()+" is invoked!");
        return method.invoke(target,args);
    }
}
