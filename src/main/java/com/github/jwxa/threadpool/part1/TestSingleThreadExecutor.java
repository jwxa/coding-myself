package com.github.jwxa.threadpool.part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/3/20 ProjectName: coding-myself Version: 1.0
 */
public class TestSingleThreadExecutor {

    public static void main(String[] args) {
        //����һ�������ù̶��߳������̳߳�
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //����ʵ����Runnable�ӿڶ���
        Thread tt1 = new MyThread();
        Thread tt2 = new MyThread();
        Thread tt3 = new MyThread();
        Thread tt4 = new MyThread();
        Thread tt5 = new MyThread();
        //���̷߳�����в�ִ��
        pool.execute(tt1);
        pool.execute(tt2);
        pool.execute(tt3);
        pool.execute(tt4);
        pool.execute(tt5);
        //�ر�
        pool.shutdown();
        System.out.println("main over");
    }
}
