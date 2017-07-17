package com.github.jwxa.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Java����֮CyclicBarrier
 * http://www.jianshu.com/p/a1d92ceadbe7
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/7/17 ProjectName: coding-myself Version: 1.0
 */
public class CyclicBarrierDemo {

    private static final int THREAD_SIZE = 5;
    private static Runnable signalRunnable = () -> System.out.println("����ǹ���ˣ��ܣ�");

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }


    /**
     * �������ָ���ĵȴ�ʱ�䣬��ǰ�̻߳��׳� TimeoutException �쳣�������̻߳��׳�BrokenBarrierException�쳣��
     */
    private static void test5() {
        CyclicBarrier barrier = new CyclicBarrier(5, signalRunnable);
        for (int i = 0; i < 5; i++) {
            new MyThread(barrier, "�˶�Ա" + i + "��", i,true).start();
        }
    }

    /**
     * �����ִ�����ϲ��������з����쳣������쳣����������ǰ�߳��У������̻߳��׳�BrokenBarrierException�����ϱ��𻵡�
     * ����ͺñ��˶�Ա��û�����⣬���ǲ��г������ˡ�����Ȩ���Ƚϴ�ֱ�Ӹ������е��˶�Ա�����첻�����ˣ����Ƕ��ؼҰɣ�
     */
    private static void test4() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, ()->{
            String str = null;
            str.substring(0, 1);
            System.out.println("����ǹ���ˣ��ܣ�");
        });
        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread(cyclicBarrier,"�˶�Ա"+i+"��",i);
            t.start();
        }
    }

    /**
     * ����ڵȴ��Ĺ����У��̱߳��жϣ�Ҳ���׳�BrokenBarrierException�쳣����������쳣�ᴫ�����������е��̡߳�
     * ��������Կ���������һ���̱߳��жϣ���ô���е��˶�Ա���˳��ˡ�
     * @throws InterruptedException
     */
    private static void test3() throws InterruptedException {
        Map<Integer, Thread> threads = new HashMap<>();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, signalRunnable);
        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread(cyclicBarrier,"�˶�Ա"+i+"��",i);
            threads.put(i,t);
            t.start();
        }
        Thread.sleep(3000);
        threads.get(1).interrupt();
    }

    /**
     * 1.������߳��Ѿ����ڵȴ�״̬������reset�����ᵼ���Ѿ��ڵȴ����̳߳���BrokenBarrierException�쳣��
     * �������ڳ�����BrokenBarrierException�����ᵼ��ʼ���޷��ȴ���
     * <p>
     * ��������Կ������˶�Ա0���ڵȴ��Ĺ����У����̵߳�����reset�����������׳�BrokenBarrierException�쳣��
     * ���������̲߳�û���ܵ�Ӱ�죬���ǻ�һֱ�ȴ���ȥ���Ӷ�һֱ��������
     *
     * @throws InterruptedException
     */
    private static void test2() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5, signalRunnable);
        for (int i = 0; i < 5; i++) {
            new MyThread(barrier, "�˶�Ա" + i + "��", i).start();
        }
        Thread.sleep(1000);
        barrier.reset();
    }

    /**
     * ��������Կ���,�����������Ĳ����ߣ��̣߳�������await()����֮�����Ϸſ���CyclicBarrier�е����϶����������ˡ�
     * ���û�дﵽָ�����������ͻ�һֱ��������
     */
    private static void test1() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_SIZE, signalRunnable);
        for (int i = 0; i < THREAD_SIZE; i++) {
            new MyThread(cyclicBarrier, "�˶�Ա" + i + "��", i).start();
        }
    }

}

class MyThread extends Thread {
    private CyclicBarrier cyclicBarrier;

    private String name;

    private int id;

    /**
     * Ĭ�ϲ�ʹ�ó�ʱ����
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
        System.out.println(name + "��ʼ׼��");
        try {
            Thread.sleep(id * 1000);  //��ͬ�˶�Ա׼��ʱ�䲻һ��������ģ�ⲻͬ���
            System.out.println(name + "׼����ϣ��ȴ�����ǹ");
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
                System.out.println(name + "������·�̣�");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
                System.out.println(name + "��������������");
            }

            System.out.println(name + "�˳���");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
