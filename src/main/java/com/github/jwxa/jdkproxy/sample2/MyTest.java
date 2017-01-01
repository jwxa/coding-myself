package com.github.jwxa.jdkproxy.sample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * http://www.360doc.com/content/14/0801/14/1073512_398598312.shtml
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/31 ProjectName: coding-myself Version: 1.0
 */
public class MyTest {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        InputStream is = new FileInputStream(file.getCanonicalPath()+"\\target\\classes\\com\\github\\jwxa\\jdkproxy\\sample2\\Programmer.class");
        byte[] result = new byte[1024];
        int count = is.read(result);
        MyClassLoader loader = new MyClassLoader();
        Class clazz = loader.defineMyClass(result,0,count);
        System.out.println(clazz.getCanonicalName());
        try {
            Object o = clazz.newInstance();
            clazz.getMethod("code",null).invoke(o,null);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
