package com.github.jwxa.multithread;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ʹ��ReentrantLockģ��Synchronized
 * <p>
 * ���������б�
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
                    System.out.println("T1��ȡ����lock����ʼִ��");
                    lock.lock();
                    try {
                        TimeUnit.MINUTES.sleep(1);
                        System.out.println("T1�� await()ʱ������");
                        t2BizOk.await();//�ȴ�t2ִ����
                        System.out.println("T1��T2���Ѻ����»��synObj�Ķ��������������ִ��");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                        System.out.println("T1��ȡsynObj�Ķ��������������ͬ����");
                    }
            }
        });

        t1.start();

        Collections.reverseOrder();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T2������������ΪT1ռ������lock����ȴ�T1ִ��condition.await���ͷ���");
                lock.lock();
                    try {
                        System.out.println("��T1ִ��condition.await��T2��ȡlock��ִ�к�������");
                        t2BizOk.signal();
                        System.out.println("T2ִ����T1ִ��condition.signal()��T1�����ѣ���T2��û��unlock��T1�ȴ�T2��unlock");
                        TimeUnit.MINUTES.sleep(1);
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                        lock.unlock();
                        System.out.println("T2�������룬unlock��T1��ȡ��������ִ��wait����Ĳ���");
                    }
            };
        });
        t2.start();

    }

}


