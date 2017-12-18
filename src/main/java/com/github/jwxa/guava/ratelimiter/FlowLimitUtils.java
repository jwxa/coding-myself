package com.github.jwxa.guava.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://xujin.org/mw/flowlimit01/
 * 网关两种限流调研
 * 使用 Guava 的 RateLimiter 来实现基于令牌桶的流量控制
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/12/18 ProjectName: coding-myself Version: 1.0
 */
public class FlowLimitUtils {


    private static final ConcurrentMap<String, RateLimiter> resourceRateLimiterMap = new ConcurrentHashMap<String, RateLimiter>();

    public static void createFlowLimitMap(String resource, double qps) {
        RateLimiter limiter = resourceRateLimiterMap.get(resource);
        if (limiter == null) {
            limiter =RateLimiter.create(qps);
            resourceRateLimiterMap.putIfAbsent(resource, limiter);
        }
        limiter.setRate(qps);
    }

    public static boolean enter(String resource) throws Exception {
        RateLimiter limiter = resourceRateLimiterMap.get(resource);
        if (limiter == null) {
            throw new Exception(resource);
        }
        if (!limiter.tryAcquire()) {
            System.out.println(">>>>>>>>>>>>>>>>>被限流了>>>>>>>>");
            return true;
        }
        return false;
    }

    static class TestWork implements Runnable{
        @Override
        public void run() {
            try {
                if(!enter("test")){
                    System.out.println("++++++++++++ 没有被限流");
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        String source="test";
        double qps=10;
        createFlowLimitMap(source, qps);
        Thread.sleep(1000l);
        ExecutorService pools= Executors.newFixedThreadPool(40);
        for(int i=0;i<40;i++){
            TestWork testWork=new TestWork();
            pools.execute(testWork);
        }
    }




}
