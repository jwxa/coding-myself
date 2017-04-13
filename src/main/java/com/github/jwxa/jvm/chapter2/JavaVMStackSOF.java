package com.github.jwxa.jvm.chapter2;

/**
 * �����ջ�ͱ��ط���ջ���
 * VM Args��-Xss128k ջ���
 * ջ����ֻ��-Xss�����趨��
 * User: Jwxa Date: 2017/4/10 ProjectName: coding-myself Version: 1.0
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length��" + oom.stackLength);
            throw e;
        }
    }

}
