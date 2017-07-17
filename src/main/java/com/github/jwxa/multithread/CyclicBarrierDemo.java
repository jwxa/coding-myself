package com.github.jwxa.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Java并发之CyclicBarrier
 * http://www.jianshu.com/p/a1d92ceadbe7
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/7/17 ProjectName: coding-myself Version: 1.0
 */
public class CyclicBarrierDemo {

    private static final int THREAD_SIZE = 5;
    private static Runnable signalRunnable = () -> System.out.println("发令枪响了，跑！");

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }


    /**
     * 如果超出指定的等待时间，当前线程会抛出 TimeoutException 异常，其他线程会抛出BrokenBarrierException异常。
     */
    private static void test5() {
        CyclicBarrier barrier = new CyclicBarrier(5, signalRunnable);
        for (int i = 0; i < 5; i++) {
            new MyThread(barrier, "运动员" + i + "号", i,true).start();
        }
    }

    /**
     * 如果在执行屏障操作过程中发生异常，则该异常将传播到当前线程中，其他线程会抛出BrokenBarrierException，屏障被损坏。
     * 这个就好比运动员都没有问题，而是裁判出问题了。裁判权力比较大，直接告诉所有的运动员，今天不比赛了，你们都回家吧！
     */
    private static void test4() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, ()->{
            String str = null;
            str.substring(0, 1);
            System.out.println("发令枪响了，跑！");
        });
        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread(cyclicBarrier,"运动员"+i+"号",i);
            t.start();
        }
    }

    /**
     * 如果在等待的过程中，线程被中断，也会抛出BrokenBarrierException异常，并且这个异常会传播到其他所有的线程。
     * 从输出可以看到，其中一个线程被中断，那么所有的运动员都退场了。
     * @throws InterruptedException
     */
    private static void test3() throws InterruptedException {
        Map<Integer, Thread> threads = new HashMap<>();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, signalRunnable);
        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread(cyclicBarrier,"运动员"+i+"号",i);
            threads.put(i,t);
            t.start();
        }
        Thread.sleep(3000);
        threads.get(1).interrupt();
    }

    /**
     * 1.如果有线程已经处于等待状态，调用reset方法会导致已经在等待的线程出现BrokenBarrierException异常。
     * 并且由于出现了BrokenBarrierException，将会导致始终无法等待。
     * <p>
     * 从输出可以看到，运动员0号在等待的过程中，主线程调用了reset方法，导致抛出BrokenBarrierException异常。
     * 但是其他线程并没有受到影响，它们会一直等待下去，从而一直被阻塞。
     *
     * @throws InterruptedException
     */
    private static void test2() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5, signalRunnable);
        for (int i = 0; i < 5; i++) {
            new MyThread(barrier, "运动员" + i + "号", i).start();
        }
        Thread.sleep(1000);
        barrier.reset();
    }

    /**
     * 从输出可以看到,当给定数量的参与者（线程）调用了await()方法之后，屏障放开，CyclicBarrier中的屏障动作被触发了。
     * 如果没有达到指定的数量，就会一直被阻塞。
     */
    private static void test1() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_SIZE, signalRunnable);
        for (int i = 0; i < THREAD_SIZE; i++) {
            new MyThread(cyclicBarrier, "运动员" + i + "号", i).start();
        }
    }

}

class MyThread extends Thread {
    private CyclicBarrier cyclicBarrier;

    private String name;

    private int id;

    /**
     * 默认不使用超时机制
     */
    private  boolean awaitTimeoutFlag = false;


    public MyThread(CyclicBarrier cyclicBarrier, String name, int id) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.id = id;
    }

    public MyThread(CyclicBarrier cyclicBarrier, String name, int id, boolean awaitTimeoutFlag) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.id = id;
        this.awaitTimeoutFlag = awaitTimeoutFlag;
    }

    @Override
    public void run() {
        System.out.println(name + "开始准备");
        try {
            Thread.sleep(id * 1000);  //不同运动员准备时间不一样，方便模拟不同情况
            System.out.println(name + "准备完毕！等待发令枪");
            try {
                if(awaitTimeoutFlag){
                    try {
                        cyclicBarrier.await(id * 1000, TimeUnit.MILLISECONDS);
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                } else {
                    cyclicBarrier.await();
                }
                System.out.println(name + "跑完了路程！");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
                System.out.println(name + "看不见起跑线了");
            }

            System.out.println(name + "退场！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
