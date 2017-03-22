package com.github.jwxa.threadpool.part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/3/20 ProjectName: coding-myself Version: 1.0
 */
public class TestSingleThreadExecutor {

    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //创建实现了Runnable接口对象
        Thread tt1 = new MyThread();
        Thread tt2 = new MyThread();
        Thread tt3 = new MyThread();
        Thread tt4 = new MyThread();
        Thread tt5 = new MyThread();
        //将线程放入池中并执行
        pool.execute(tt1);
        pool.execute(tt2);
        pool.execute(tt3);
        pool.execute(tt4);
        pool.execute(tt5);
        //关闭
        pool.shutdown();
        System.out.println("main over");
    }
}
