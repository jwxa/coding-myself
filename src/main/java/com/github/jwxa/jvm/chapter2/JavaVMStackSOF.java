package com.github.jwxa.jvm.chapter2;

/**
 * 虚拟机栈和本地方法栈溢出
 * VM Args：-Xss128k 栈溢出
 * 栈容量只由-Xss参数设定。
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
            System.out.println("stack length：" + oom.stackLength);
            throw e;
        }
    }

}
