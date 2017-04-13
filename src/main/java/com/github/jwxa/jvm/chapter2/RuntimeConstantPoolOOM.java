package com.github.jwxa.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ʱ�����ص��µ��ڴ�����쳣
 * VM Args��-XX:PermSize=10M -XX:MaxPermSize=10M jdk7
 * ��jdk1.7�����ϲ������
 * User: Jwxa Date: 2017/4/11 ProjectName: coding-myself Version: 1.0
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
//        String str1 = new StringBuilder("�����").append("���").toString();
//        System.out.println(str1.intern()==str1);
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern()==str2);

        //ʹ��List�����ų��������ã�����Full GC���ճ�������Ϊ
        List<String> list = new ArrayList<String>();
        //10MB��PermSize��integer��Χ���㹻����OOM��
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
