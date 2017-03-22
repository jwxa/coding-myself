package com.github.jwxa.threadpool.part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://blog.luoyuanhang.com/2017/02/26/thread-pool-in-java-1/
 * 不同线程池的说明
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/3/20 ProjectName: coding-myself Version: 1.0
 */
public class Demo1 {

    public static void main(String[] args) {
        //SingleThreadExecutor是单个线程的线程池，即线程池中每次只有一个线程在运行，单线程串行执行任务。
        //如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();


        //FixedThreadPool是固定数量的线程池，只有核心线程，每提交一个任务就是一个线程，直到达到线程池的最大数量，然后后面进入等待队列，直到前面的任务完成才继续执行。
        //线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
        ExecutorService fixedThreadPool =  Executors.newFixedThreadPool(10);

        //CachedThreadPool是可缓存线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
        //此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。其中，SynchronousQueue是一个是缓冲区为1的阻塞队列。
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //ScheduledThreadPool是核心线程池固定，大小无限制的线程池，支持定时和周期性的执行线程。
        // 创建一个周期性执行任务的线程池。如果闲置,非核心线程池会在DEFAULT_KEEPALIVEMILLIS时间内回收。
        ExecutorService executorService = Executors.newScheduledThreadPool(10);

    }
}
