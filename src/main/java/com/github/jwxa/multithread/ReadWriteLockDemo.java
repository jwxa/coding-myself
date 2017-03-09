package com.github.jwxa.multithread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ��д��
 *
 * Java�еĶ�д����ReadWriteLock������Ϊ���ֶ���д�ٵĳ����������
 *
 * <p>
 * һ��**ReentrantReadWriteLock**ʵ��
 * ����һ��**ReentrantReadWriteLock.ReadLock**ʵ��
 * ��һ��**ReentrantReadWriteLock.WriteLock**ʵ����
 * ͨ��*readLock()*��*writeLock()*�����ɷֱ��ö���ʵ����д��ʵ������ͨ��Lock�ӿ��ṩ�Ļ�ȡ��������ö�Ӧ������
 * </p>
 * User: Jwxa Date: 2017/3/5 ProjectName: coding-myself Version: 1.0
 */
public class ReadWriteLockDemo {

    /**
     * ��д���������������£�
     - ��ö����������߳̿ɻ�ö��������ܻ�ȡд��
     - ���д���������̼߳Ȳ��ܻ�ö���Ҳ���ܻ��д��
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
