package com.github.jwxa.jvm.chapter2;

/**
 * 创建线程导致内存溢出异常
 * VM Args：-Xss2M（这时候不妨设置大些）
 * User: Jwxa Date: 2017/4/11 ProjectName: coding-myself Version: 1.0
 */
public class JavaVMStackOOM {

    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }


    private void dontStop(){
        while(true){

        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
}
