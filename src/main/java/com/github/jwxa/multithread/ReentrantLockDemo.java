package com.github.jwxa.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java中的重入锁（即ReentrantLock）与Java内置锁一样，是一种排它锁。使用synchronized的地方一定可以用ReentrantLock代替。
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/3/5 ProjectName: coding-myself Version: 1.0
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        /**
         * 公平锁是指多个线程获取锁被阻塞的情况下，锁变为可用时，最新申请锁的线程获得锁。
         * 可通过在重入锁（RenentrantLock）的构造方法中传入true构建公平锁，如Lock lock = new RenentrantLock(true)
         */
        /**
         * 非公平锁是指多个线程等待锁的情况下，锁变为可用状态时，哪个线程获得锁是随机的。
         * synchonized相当于非公平锁。可通过在重入锁的构造方法中传入false或者使用无参构造方法构建非公平锁。
         */
        final Lock reentrantLock = new ReentrantLock();

        Thread thread1 = new Thread(()->{
            System.out.println("thread1 start");
            try{
                reentrantLock.lock();
                // 用户操作
                System.out.println("thread1 lock");
                while(true){

                }
            } finally {
                reentrantLock.unlock();
                System.out.println("thread1 unlock");
            }
        });
        thread1.setName("jwxa-thread1");
        thread1.start();
        for (int i = 0; i < 200000; i++) {

        }
        Thread thread2 = new Thread(()->{
            System.out.println("thread2 start");
            try{
                reentrantLock.lock();
                System.out.println("thread2 lock");
                // 这里应该处于阻塞
            } finally {
                reentrantLock.unlock();
                System.out.println("thread2 unlock");

            }
        });
        thread2.setName("jwxa-thread2");
        thread2.start();

    }
}
