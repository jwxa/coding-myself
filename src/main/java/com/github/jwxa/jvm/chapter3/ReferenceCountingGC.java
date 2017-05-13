package com.github.jwxa.jvm.chapter3;

/**
 * ���ü����㷨��ȱ��
 * testGC��������ִ�к�objA��objB�᲻�ᱻGC�أ�
 * JVM Args:-XX:+PrintHeapAtGC ���ڴ�ӡ���ڴ���gcʱ��
 * Java GC��־����ͨ�� +PrintGCDetails���� �����õ����
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/4/13 ProjectName: coding-myself Version: 1.0
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * �����Ա��Ψһ�������ռ���ڴ棬�Ա�����GC��־�п�����Ƿ���չ�
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        //���������з���GC,objA��objB�Ƿ��ܱ����գ�
        System.gc();
    }

}
