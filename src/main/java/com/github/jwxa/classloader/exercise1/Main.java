package com.github.jwxa.classloader.exercise1;

import sun.reflect.misc.MethodUtil;

import java.lang.reflect.InvocationTargetException;

/**
 * Java 技术之类加载机制
 * http://wingjay.com/2017/05/08/java_classloader/
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/6/24 ProjectName: coding-myself Version: 1.0
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        loadClass();
    }


    private static void loadClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        do {
            String className = "com.github.jwxa.classloader.exercise1.MusicPlayer";
            ClassLoader classLoader = new NetworkClassLoader();
            Class<?> clazz  = classLoader.loadClass(className);
            Object musicPlayer = clazz.newInstance();
            MethodUtil.getMethod(clazz,"print",null).invoke(musicPlayer);
            System.out.printf("ClassLoader is %s\n", classLoader.getClass().getSimpleName());
            while (classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
                System.out.printf("Parent is %s\n", classLoader.getClass().getSimpleName());
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
