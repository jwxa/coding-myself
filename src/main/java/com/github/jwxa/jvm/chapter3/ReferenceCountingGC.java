package com.github.jwxa.jvm.chapter3;

/**
 * 引用计数算法的缺陷
 * testGC（）方法执行后，objA和objB会不会被GC呢？
 * JVM Args:-XX:+PrintHeapAtGC 用于打印堆内存在gc时候
 * Java GC日志可以通过 +PrintGCDetails开启 这里用的这个
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/13 ProjectName: coding-myself Version: 1.0
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员的唯一意义就是占点内存，以便能在GC日志中看清楚是否回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        //假设在这行发生GC,objA和objB是否能被回收？
        System.gc();
    }

}
