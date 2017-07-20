package com.github.jwxa.classloader.exercise1;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * ������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/6/24 ProjectName: coding-myself Version: 1.0
 */
public class NetworkClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = downloadClassData(name); // ��Զ������
        if (classData == null) {
            super.findClass(name); // δ�ҵ������쳣
        } else {
            return defineClass(name, classData, 0, classData.length); // convert class byte data to Class<?> object
        }
        return null;
    }


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("loadClass start");
        return super.loadClass(name);

    }

    private byte[] downloadClassData(String name) {
        // �� localhost ���� .class �ļ�
        String path = "http://localhost:32769" + "/" + "java" + "/" + name.replace('.', '/') + ".class";
        try {
            URL url = new URL(path);
            InputStream ins = url.openStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead); // �����صĶ��������ݴ��� ByteArrayOutputStream
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        System.out.printf("Real NetworkClassLoader\n");
        return "networkClassLoader";
    }



}
