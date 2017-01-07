package com.github.jwxa.jdkproxy.sample4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * ������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/1 ProjectName: coding-myself Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        ElectricCar car = new ElectricCar();
        //1.��ȡ��Ӧ��ClassLoader
        ClassLoader classLoader = car.getClass().getClassLoader();
        //2.��ȡElectricCar��ʵ�ֵ����нӿ�
        Class[] interfaces = car.getClass().getInterfaces();
        //3.����һ�����Դ����������ķ������������������������еĴ��������ϵķ�������
        InvocationHandler handler = new InvocationHandlerImpl(car);
        /*
        4.���������ṩ����Ϣ�������������� ����������У�
               a.JDK��ͨ�����ݴ���Ĳ�����Ϣ��̬�����ڴ��д�����.class �ļ���ͬ���ֽ���
               b.Ȼ�������Ӧ���ֽ���ת���ɶ�Ӧ��class��
               c.Ȼ�����newInstance()����ʵ��
        */
        Object o = Proxy.newProxyInstance(classLoader,interfaces,handler);
        Vehicle vehicle = (Vehicle) o;
        vehicle.drive();
        Rechargable rechargable = (Rechargable) o;
        rechargable.recharge();
    }
}