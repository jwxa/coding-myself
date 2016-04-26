package com.github.jwxa.designpattern.creational.prototype;

import java.io.*;

/**
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。<br>
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。<br>
 * 此处，写一个深浅复制的例子<br>
 * User: Jwxa
 * Date: 2016/4/13.
 */
public class Prototype2 implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private String string;

    private SerializableObject obj;

    /**
     * 浅复制
     */
    public Object clone() throws CloneNotSupportedException {
        Prototype2 prototype2 = (Prototype2) super.clone();
        return prototype2;
    }

    /**
     * 深复制
     *
     * @return
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        /**
         * 写入当前对象的二进制流
         */
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        /**
         * 读出二进制流产生新的对象
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
