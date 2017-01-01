package com.github.jwxa.jdkproxy.sample2;

/**
 * 自定义一个类加载器，用于将字节码转换为class对象
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/31 ProjectName: coding-myself Version: 1.0
 */
public class MyClassLoader extends ClassLoader {

    public Class<?> defineMyClass( byte[] b, int off, int len)
    {
        return super.defineClass(b, off, len);
    }

}
