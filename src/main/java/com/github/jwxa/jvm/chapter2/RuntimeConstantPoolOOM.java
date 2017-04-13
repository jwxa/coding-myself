package com.github.jwxa.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常
 * VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M jdk7
 * 在jdk1.7及以上不会溢出
 * User: Jwxa Date: 2017/4/11 ProjectName: coding-myself Version: 1.0
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern()==str1);
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern()==str2);

        //使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        //10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
