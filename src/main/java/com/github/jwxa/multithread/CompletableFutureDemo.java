package com.github.jwxa.multithread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * http://www.jianshu.com/p/dff9063e1ab6?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 * <p>
 * 方法描述列表
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
     * 如果使用completeExceptionally(Throwable ex)则抛出一个异常，而不是一个成功的结果
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
     * 如果future已经执行完毕能够返回结果，此时再调用complete(T t)则会无效。
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
     * future.get()在等待执行结果时，程序会一直block，如果此时调用complete(T t)会立即执行。
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
     * supplyAsync返回的CompletableFuture是由返回值的
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
     * runAsync返回的CompletableFuture是没有返回值的。
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
