package com.github.jwxa.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java�е�����������ReentrantLock����Java������һ������һ����������ʹ��synchronized�ĵط�һ��������ReentrantLock���档
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/3/5 ProjectName: coding-myself Version: 1.0
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        /**
         * ��ƽ����ָ����̻߳�ȡ��������������£�����Ϊ����ʱ���������������̻߳������
         * ��ͨ������������RenentrantLock���Ĺ��췽���д���true������ƽ������Lock lock = new RenentrantLock(true)
         */
        /**
         * �ǹ�ƽ����ָ����̵߳ȴ���������£�����Ϊ����״̬ʱ���ĸ��̻߳����������ġ�
         * synchonized�൱�ڷǹ�ƽ������ͨ�����������Ĺ��췽���д���false����ʹ���޲ι��췽�������ǹ�ƽ����
         */
        final Lock reentrantLock = new ReentrantLock();

        Thread thread1 = new Thread(()->{
            System.out.println("thread1 start");
            try{
                reentrantLock.lock();
                // �û�����
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
                // ����Ӧ�ô�������
            } finally {
                reentrantLock.unlock();
                System.out.println("thread2 unlock");

            }
        });
        thread2.setName("jwxa-thread2");
        thread2.start();

    }
}
