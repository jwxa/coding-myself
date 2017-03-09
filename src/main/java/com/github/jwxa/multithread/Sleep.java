package com.github.jwxa.multithread;

import java.util.Date;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/3/5 ProjectName: coding-myself Version: 1.0
 */
public class Sleep {

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
           synchronized (Sleep.class){
               try {
                   System.out.println(new Date() + " Thread1 is running");
                   Thread.sleep(2000);
                   System.out.println(new Date() + " Thread1 ended");
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           }
        });

        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (Sleep.class) {
                try {
                    System.out.println(new Date() + " Thread2 is running");
                    Thread.sleep(2000);
                    System.out.println(new Date() + " Thread2 ended");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            for(long i = 0; i < 200000; i++) {
                for(long j = 0; j < 100000; j++) {}
            }
        });

        // Don't use sleep method to avoid confusing
        for(long i = 0; i < 200000; i++) {
            for(long j = 0; j < 100000; j++) {}
        }
        thread2.start();
    }
}
