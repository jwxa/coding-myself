package com.github.jwxa.multithread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *
 * Java中的读写锁（ReadWriteLock）就是为这种读多写少的场景而创造的
 *
 * <p>
 * 一个**ReentrantReadWriteLock**实例
 * 包含一个**ReentrantReadWriteLock.ReadLock**实例
 * 和一个**ReentrantReadWriteLock.WriteLock**实例。
 * 通过*readLock()*和*writeLock()*方法可分别获得读锁实例和写锁实例，并通过Lock接口提供的获取锁方法获得对应的锁。
 * </p>
 * User: Jwxa Date: 2017/3/5 ProjectName: coding-myself Version: 1.0
 */
public class ReadWriteLockDemo {

    /**
     * 读写锁的锁定规则如下：
     - 获得读锁后，其它线程可获得读锁而不能获取写锁
     - 获得写锁后，其它线程既不能获得读锁也不能获得写锁
     * @param args
     */
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        new Thread(()->{
            readWriteLock.readLock().lock();
            try {
                System.out.println("thread 1 started with  read lock");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 1 ended");
            } finally {
                readWriteLock.readLock().unlock();
            }
        }).start();


        new Thread(()->{
            readWriteLock.readLock().lock();
            try {
                System.out.println("thread 2 started with read lock");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 2 ended");
            } finally {
                readWriteLock.readLock().unlock();
            }
        }).start();

        new Thread(()->{
            readWriteLock.writeLock().lock();
            try {
                System.out.println("thread 3 started with write lock");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 3 ended");
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }).start();

    }
}
