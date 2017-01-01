package com.github.jwxa.jdkproxy.sample4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/1 ProjectName: coding-myself Version: 1.0
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private ElectricCar car;

    public InvocationHandlerImpl(ElectricCar car) {
        this.car = car;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("You are going to invoke "+method.getName()+" ...");
        method.invoke(car, null);
        System.out.println(method.getName()+" invocation Has Been finished...");
        return null;
    }
}
