package com.github.jwxa.jdkproxy.sample5;

import net.sf.cglib.proxy.Enhancer;

/**
 * JDK���ṩ�����ɶ�̬������Ļ����и��������ص��ǣ� ĳ���������ʵ�ֵĽӿڣ������ɵĴ�����Ҳֻ�ܴ���ĳ����ӿڶ���ķ��������磺����������ӵ�ElectricCarʵ���˼̳��������ӿڵķ����⣬����ʵ���˷���bee() ,���ڲ����Ķ�̬�������в�������������ˣ������˵�����ǣ����ĳ����û��ʵ�ֽӿڣ���ô�����Ͳ���ͬJDK������̬�����ˣ�
 * <p>
 * �Һ�������cglib����CGLIB��Code Generation Library������һ��ǿ��ģ������ܣ���������Code������⣬����������������չJava����ʵ��Java�ӿڡ���
 * <p>
 * cglib ����ĳ����A�Ķ�̬�������ģʽ�ǣ�
 * <p>
 * 1.   ����A�ϵ����з�final ��public���͵ķ������壻
 * <p>
 * 2.   ����Щ�����Ķ���ת�����ֽ��룻
 * <p>
 * 3.   ����ɵ��ֽ���ת������Ӧ�Ĵ����class����
 * <p>
 * 4.   ʵ�� MethodInterceptor�ӿڣ��������� �Դ����������з�������������ӿں�JDK��̬����InvocationHandler�Ĺ��ܺͽ�ɫ��һ���ģ�
 * <p>
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/1 ProjectName: coding-myself Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        Hacker hacker = new Hacker();
        //cglib �м�ǿ��������������̬����
        Enhancer enhancer = new Enhancer();
        //����Ҫ������̬�������
        enhancer.setSuperclass(Programmer.class);
        // ���ûص��������൱���Ƕ��ڴ����������з����ĵ��ã��������CallBack����Callback����Ҫʵ��intercept()������������
        enhancer.setCallback(hacker);
        Programmer proxy = (Programmer) enhancer.create();
        proxy.code();
    }
}
