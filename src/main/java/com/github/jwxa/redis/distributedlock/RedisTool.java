package com.github.jwxa.redis.distributedlock;

import redis.clients.jedis.Jedis;

/**
 * Redis�ֲ�ʽ������ȷʵ�ַ�ʽ��Java�棩
 * <p>
 * http://wudashan.cn/2017/10/23/Redis-Distributed-Lock-Implement/?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 *
 �����ԡ�������ʱ�̣�ֻ��һ���ͻ����ܳ�������
 ���ᷢ����������ʹ��һ���ͻ����ڳ��������ڼ������û������������Ҳ�ܱ�֤���������ͻ����ܼ�����
 �����ݴ��ԡ�ֻҪ�󲿷ֵ�Redis�ڵ��������У��ͻ��˾Ϳ��Լ����ͽ�����
 ���廹��ϵ���ˡ������ͽ���������ͬһ���ͻ��ˣ��ͻ����Լ����ܰѱ��˼ӵ��������ˡ�

 * </p>
 * User: Jwxa Date: 2017/11/26 ProjectName: coding-myself Version: 1.0
 */
public class RedisTool {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * ���Ի�ȡ�ֲ�ʽ��
     * @param jedis Redis�ͻ���
     * @param lockKey ��
     * @param requestId �����ʶ
     * @param expireTime ����ʱ��
     * @return �Ƿ��ȡ�ɹ�
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

    /**
     * �Ƚϳ����Ĵ���ʾ������ʹ��jedis.setnx()��jedis.expire()���ʵ�ּ������������£�
     * @param jedis
     * @param lockKey
     * @param requestId
     * @param expireTime
     */
    public static void wrongGetLock1(Jedis jedis, String lockKey, String requestId, int expireTime) {
        Long result = jedis.setnx(lockKey, requestId);
        if (result == 1) {
            // �����������ͻȻ���������޷����ù���ʱ�䣬����������
            jedis.expire(lockKey, expireTime);
        }
    }





}
