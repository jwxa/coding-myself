package com.github.jwxa.multithread;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock模拟Synchronized
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/2/19 ProjectName: coding-myself Version: 1.0
 */
public class ReentrantLockConditionAwaitSignalTest {



    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition t2BizOk = lock.newCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                    System.out.println("T1获取锁并lock，开始执行");
                    lock.lock();
                    try {
                        TimeUnit.MINUTES.sleep(1);
                        System.out.println("T1在 await()时挂起了");
                        t2BizOk.await();//等待t2执行先
                        System.out.println("T1被T2唤醒后并重新获得synObj的对象监视器，继续执行");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                        System.out.println("T1获取synObj的对象监视器，结束同步块");
                    }
            }
        });

        t1.start();

        Collections.reverseOrder();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T2启动，但是因为T1占用了锁lock，则等待T1执行condition.await来释放它");
                lock.lock();
                    try {
                        System.out.println("在T1执行condition.await后，T2获取lock，执行后续代码");
                        t2BizOk.signal();
                        System.out.println("T2执行在T1执行condition.signal()，T1被唤醒，但T2还没有unlock，T1等待T2的unlock");
                        TimeUnit.MINUTES.sleep(1);
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                        lock.unlock();
                        System.out.println("T2结束代码，unlock，T1获取到锁，并执行wait后面的操作");
                    }
            };
        });
        t2.start();

    }

}


