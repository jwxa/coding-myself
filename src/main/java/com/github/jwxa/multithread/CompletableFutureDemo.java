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
 * 方法描述列表
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
        // 全流式处理转换成CompletableFuture[]+组装成一个无返回值CompletableFuture，join等待执行完毕。返回结果whenComplete获取
        List<String> collect = null;
        try {
            collect = taskList.parallelStream()
//                    .map(integer -> CompletableFuture.supplyAsync(() -> calc(integer), executorService)
//                            .thenApply(h -> {
//                                System.out.println(h + " 用时：" + System.currentTimeMillis());
//                                return h + " 用时：" + System.currentTimeMillis();
//                            })
                    .map((integer -> {
                                int h = calc(integer);
                                System.out.println(h + " 用时：" + System.currentTimeMillis());
                                return h + " 用时：" + System.currentTimeMillis();
                            })
                    ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(collect);

        // 封装后无返回值，必须自己whenComplete()获取
//        System.out.println("埋点1：{}" + (System.currentTimeMillis() - start));
//        try {
//            Object obj = cfs[0].get();
//            System.out.println(obj);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        System.out.println("埋点2：{}" + (System.currentTimeMillis() - start));
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
//        System.out.println("埋点3：{}" + (System.currentTimeMillis() - start));
//        System.out.println("list=" + list + ",耗时=" + (System.currentTimeMillis() - start));
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
