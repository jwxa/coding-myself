package com.github.jwxa.multithread;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * http://www.jianshu.com/p/dff9063e1ab6?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/9/19 ProjectName: coding-myself Version: 1.0
 */
public class CompletableFutureDemo {
//
//    public static void main(String[] args) {
////        test1();
////        test2();
////        test3();
////        test4();
////        test5();
//        CompletableFutureDemo d = new CompletableFutureDemo();
//        d.aaaa();
//    }

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


    private List<String> list = Lists.newArrayList("a", "b", "c");

    private void aaaa() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return list.get(0);
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return list.get(1);
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return list.get(2);
        });
        try {
            String a = future1.get();
            String b = future2.get();
            String c = future3.get();
            System.out.println(a + "|" + b + "|" + c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        long start = System.currentTimeMillis();
        List<Integer> taskList = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 11, 12, 13);
        // ȫ��ʽ����ת����CompletableFuture[]+��װ��һ���޷���ֵCompletableFuture��join�ȴ�ִ����ϡ����ؽ��whenComplete��ȡ
        List<String> collect = null;
        try {
            collect = taskList.parallelStream()
//                    .map(integer -> CompletableFuture.supplyAsync(() -> calc(integer), executorService)
//                            .thenApply(h -> {
//                                System.out.println(h + " ��ʱ��" + System.currentTimeMillis());
//                                return h + " ��ʱ��" + System.currentTimeMillis();
//                            })
                    .map((integer -> {
                                int h = calc(integer);
                                System.out.println(h + " ��ʱ��" + System.currentTimeMillis());
                                return h + " ��ʱ��" + System.currentTimeMillis();
                            })
                    ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(collect);

        // ��װ���޷���ֵ�������Լ�whenComplete()��ȡ
//        System.out.println("���1��{}" + (System.currentTimeMillis() - start));
//        try {
//            Object obj = cfs[0].get();
//            System.out.println(obj);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        System.out.println("���2��{}" + (System.currentTimeMillis() - start));
//        List<String> collect = Stream.of(cfs).parallel().map((e) -> {
//            try {
//                return e.get();
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            } catch (ExecutionException e1) {
//                e1.printStackTrace();
//            }
//            return null;
//        }).collect(Collectors.toList());
//        System.out.println(collect);
//        System.out.println("���3��{}" + (System.currentTimeMillis() - start));
//        System.out.println("list=" + list + ",��ʱ=" + (System.currentTimeMillis() - start));
    }


    public static int calc(Integer integer) {
        if (integer == 1) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            throw new RuntimeException("1111111");
        }
        return integer;

    }


}
