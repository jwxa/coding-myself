package com.github.jwxa.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/7/8 ProjectName: coding-myself Version: 1.0
 */
public class ReentrantLockConditionDemo {
    static class NumberWrapper {
        public int value = 1;
    }

    public static void main(String[] args) throws InterruptedException {
        //��ʼ����������
        final Lock lock = new ReentrantLock();

        //��һ����������Ļ�������3
        final Condition reachThreeCondition = lock.newCondition();
        //�ڶ�����������Ļ�������6
        final Condition reachSixCondition = lock.newCondition();

        //NumberWrapperֻ��Ϊ�˷�װһ�����֣�һ�߿��Խ����ֶ���������������Ϊfinal
        //ע�����ﲻҪ��Integer, Integer �ǲ��ɱ����
        final NumberWrapper num = new NumberWrapper();
        //��ʼ��A�߳�
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadA start");
                //��Ҫ�Ȼ����
                System.out.println("threadA try get lock");
                lock.lock();
                System.out.println("threadA lock get");
                try {
                    System.out.println("threadA start write");
                    //A�߳������ǰ3����
                    while (num.value <= 3) {
                        System.out.println(num.value);
                        num.value++;
                    }
                    //�����3ʱҪsignal������B�߳̿��Կ�ʼ��
                    reachThreeCondition.signal();
                    System.out.println("reachThreeCondition signal");
                } finally {
                    lock.unlock();
                    System.out.println("threadA unlock");
                }
                lock.lock();
                System.out.println("threadA lock get again");
                try {
                    //�ȴ����6������
                    reachSixCondition.await();
                    System.out.println("threadA start write");
                    //���ʣ������
                    while (num.value <= 9) {
                        System.out.println(num.value);
                        num.value++;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println("threadA unlock again");
                }
            }

        });


        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadB start");
                try {
                    lock.lock();
                    System.out.println("threadB lock get");
                    System.out.println("threadB sleep 5-------------------------------------");
                    Thread.sleep(5000);
                    if (num.value <= 3) {
                        //�ȴ�3�����ϵ��ź�
                        System.out.println("reachThreeCondition await");
                        reachThreeCondition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    System.out.println("threadB try get lock");
                    lock.lock();
                    //�Ѿ��յ��źţ���ʼ���4��5��6
                    System.out.println("threadB start write");
                    while (num.value <= 6) {
                        System.out.println(num.value);
                        num.value++;
                    }
                    //4��5��6�����ϣ�����A�߳�6�������
                    reachSixCondition.signal();
                } finally {
                    lock.unlock();
                    System.out.println("threadB unlock");
                }
            }

        });


        //���������߳�
        threadB.start();
        Thread.sleep(2000);
        threadA.start();


    }
}
