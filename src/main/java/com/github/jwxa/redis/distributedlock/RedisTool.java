package com.github.jwxa.redis.distributedlock;

import redis.clients.jedis.Jedis;

/**
 * Redis分布式锁的正确实现方式（Java版）
 * <p>
 * http://wudashan.cn/2017/10/23/Redis-Distributed-Lock-Implement/?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 *
 互斥性。在任意时刻，只有一个客户端能持有锁。
 不会发生死锁。即使有一个客户端在持有锁的期间崩溃而没有主动解锁，也能保证后续其他客户端能加锁。
 具有容错性。只要大部分的Redis节点正常运行，客户端就可以加锁和解锁。
 解铃还须系铃人。加锁和解锁必须是同一个客户端，客户端自己不能把别人加的锁给解了。

 * </p>
 * User: Jwxa Date: 2017/11/26 ProjectName: coding-myself Version: 1.0
 */
public class RedisTool {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

    /**
     * 比较常见的错误示例就是使用jedis.setnx()和jedis.expire()组合实现加锁，代码如下：
     * @param jedis
     * @param lockKey
     * @param requestId
     * @param expireTime
     */
    public static void wrongGetLock1(Jedis jedis, String lockKey, String requestId, int expireTime) {
        Long result = jedis.setnx(lockKey, requestId);
        if (result == 1) {
            // 若在这里程序突然崩溃，则无法设置过期时间，将发生死锁
            jedis.expire(lockKey, expireTime);
        }
    }





}
