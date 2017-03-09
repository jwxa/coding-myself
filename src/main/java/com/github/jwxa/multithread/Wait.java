package com.github.jwxa.multithread;

import java.util.Date;

/**
 * http://www.jasongj.com/java/multi_thread/
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/3/5 ProjectName: coding-myself Version: 1.0
 */
public class Wait {

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
           synchronized (Wait.class){
               try {
                   System.out.println(new Date() + " Thread 1  is running " );
//                   boolean  flag = true;
//                   while(flag){
//                       System.out.println("如果不wait");
//                   }
                   Wait.class.wait();
                   System.out.println(new Date() + " Thread 1 ended");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });

        thread1.start();

        Thread thread2 = new Thread(()->{
            synchronized (Wait.class){
                try {
                    System.out.println(new Date() + " Thread 2  is running " );
                    Wait.class.notify();
                    for (int i = 0; i < 200000; i++) {
//                        for(long j = 0; j < 100000; j++) {}
                    }
                    System.out.println(new Date() + " Thread 2 release lock");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            for(long i = 0; i < 200000; i++) {
                for(long j = 0; j < 100000; j++) {}
            }
            System.out.println(new Date() + " Thread2 ended");

        });

        // Don't use sleep method to avoid confusing
        for(long i = 0; i < 200000; i++) {
            for(long j = 0; j < 100000; j++) {}
        }
        thread2.start();

    }
}
