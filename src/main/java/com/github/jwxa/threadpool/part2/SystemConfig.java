package com.github.jwxa.threadpool.part2;

/**
 * 系统配置类
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/3/22 ProjectName: coding-myself Version: 1.0
 */
public class SystemConfig {

    static final int THREAD_POOL_MAX_SIZE = 20;

    public static int getThreadPoolMaxSize() {
        return THREAD_POOL_MAX_SIZE;
    }
}
