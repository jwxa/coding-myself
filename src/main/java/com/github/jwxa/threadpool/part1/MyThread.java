package com.github.jwxa.threadpool.part1;

/**
 * ������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/3/20 ProjectName: coding-myself Version: 1.0
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}
