package com.github.jwxa.designpattern.creational.prototype;

import java.io.*;

/**
 * ǳ���ƣ���һ�������ƺ󣬻����������͵ı����������´��������������ͣ�ָ��Ļ���ԭ������ָ��ġ�<br>
 * ��ƣ���һ�������ƺ󣬲����ǻ����������ͻ����������ͣ��������´����ġ�����˵��������ƽ�������ȫ���׵ĸ��ƣ���ǳ���Ʋ����ס�<br>
 * �˴���дһ����ǳ���Ƶ�����<br>
 * User: Jwxa
 * Date: 2016/4/13.
 */
public class Prototype2 implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private String string;

    private SerializableObject obj;

    /**
     * ǳ����
     */
    public Object clone() throws CloneNotSupportedException {
        Prototype2 prototype2 = (Prototype2) super.clone();
        return prototype2;
    }

    /**
     * ���
     *
     * @return
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        /**
         * д�뵱ǰ����Ķ�������
         */
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        /**
         * �����������������µĶ���
         */
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
        return o;
    }


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(SerializableObject  obj) {
        this.obj = obj;
    }
}

class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;
}
