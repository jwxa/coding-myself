package com.github.jwxa.threadpool.part3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutor��ʹ��
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/11/22 ProjectName: coding-myself Version: 1.0
 */
public class TestMain {

    public static void main2(String[] args) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(5);
        for (int i = 0; i < 5; i ++){
            final int temp = i + 1;
            pool.schedule(() -> {
                System.out.println("��"+temp+"��ը����ըʱ��:" + simpleDateFormat.format(new Date()));
            }, temp * 5, TimeUnit.SECONDS);
        }
        pool.shutdown();
        System.out.println("end mainʱ��:" + simpleDateFormat.format(new Date()));
    }


    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(5);
        Runnable runnable = () -> {
            System.out.println("��ʱ����"+new Date());
        };
        pool.scheduleWithFixedDelay(runnable,0,5,TimeUnit.SECONDS);
        Thread.sleep(10000);
        pool.shutdown();
        System.out.println("main end");
        System.out.println("again");
        pool = new ScheduledThreadPoolExecutor(5);
        pool.scheduleWithFixedDelay(runnable,0,10,TimeUnit.SECONDS);
    }

}
