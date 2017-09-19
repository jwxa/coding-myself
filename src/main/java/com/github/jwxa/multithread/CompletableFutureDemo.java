package com.github.jwxa.multithread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * http://www.jianshu.com/p/dff9063e1ab6?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/9/19 ProjectName: coding-myself Version: 1.0
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    /**
     * ���ʹ��completeExceptionally(Throwable ex)���׳�һ���쳣��������һ���ɹ��Ľ��
     */
    private static void test5() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        future.completeExceptionally(new Exception());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���future�Ѿ�ִ������ܹ����ؽ������ʱ�ٵ���complete(T t)�����Ч��
     */
    private static void test4() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        future.complete("World");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * future.get()�ڵȴ�ִ�н��ʱ�������һֱblock�������ʱ����complete(T t)������ִ�С�
     */
    private static void test3() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        future.complete("World");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * supplyAsync���ص�CompletableFuture���ɷ���ֵ��
     */
    private static void test2() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("CompletableFuture");
    }

    /**
     * runAsync���ص�CompletableFuture��û�з���ֵ�ġ�
     */
    private static void test1() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello");
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("CompletableFuture");
    }


}
