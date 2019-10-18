package com.github.jwxa.multithread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://blog.csdn.net/j16421881/article/details/85471678
 */
public class ForkJoinPoolDemo {

    public static void main() throws ExecutionException, InterruptedException {
        //创建一个线程数为2的线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
//在自定义线程池里面实现并行计算质数，省略了PrimesPrint::isPrime源码
        forkJoinPool.submit(() ->
                        //parallel task here, for example
                {
                    List<String> collect = IntStream.range(1, 1_000_000).parallel().mapToObj(String::valueOf).collect(Collectors.toList());
                    return collect;
                }
        ).get();
    }
}
