package com.github.jwxa.jdkproxy.sample2;

/**
 * �Զ���һ��������������ڽ��ֽ���ת��Ϊclass����
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/31 ProjectName: coding-myself Version: 1.0
 */
public class MyClassLoader extends ClassLoader {

    public Class<?> defineMyClass( byte[] b, int off, int len)
    {
        return super.defineClass(b, off, len);
    }

}
