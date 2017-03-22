package com.github.jwxa.threadpool.part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://blog.luoyuanhang.com/2017/02/26/thread-pool-in-java-1/
 * ��ͬ�̳߳ص�˵��
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/3/20 ProjectName: coding-myself Version: 1.0
 */
public class Demo1 {

    public static void main(String[] args) {
        //SingleThreadExecutor�ǵ����̵߳��̳߳أ����̳߳���ÿ��ֻ��һ���߳������У����̴߳���ִ������
        //������Ψһ���߳���Ϊ�쳣��������ô����һ���µ��߳�������������̳߳ر�֤���������ִ��˳����������ύ˳��ִ�С�
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();


        //FixedThreadPool�ǹ̶��������̳߳أ�ֻ�к����̣߳�ÿ�ύһ���������һ���̣߳�ֱ���ﵽ�̳߳ص����������Ȼ��������ȴ����У�ֱ��ǰ���������ɲż���ִ�С�
        //�̳߳صĴ�Сһ���ﵽ���ֵ�ͻᱣ�ֲ��䣬���ĳ���߳���Ϊִ���쳣����������ô�̳߳ػᲹ��һ�����̡߳�
        ExecutorService fixedThreadPool =  Executors.newFixedThreadPool(10);

        //CachedThreadPool�ǿɻ����̳߳ء�����̳߳صĴ�С�����˴�����������Ҫ���̣߳���ô�ͻ���ղ��ֿ��У�60�벻ִ�����񣩵��̣߳�������������ʱ�����̳߳��ֿ������ܵ�������߳�����������
        //���̳߳ز�����̳߳ش�С�����ƣ��̳߳ش�С��ȫ�����ڲ���ϵͳ������˵JVM���ܹ�����������̴߳�С�����У�SynchronousQueue��һ���ǻ�����Ϊ1���������С�
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //ScheduledThreadPool�Ǻ����̳߳ع̶�����С�����Ƶ��̳߳أ�֧�ֶ�ʱ�������Ե�ִ���̡߳�
        // ����һ��������ִ��������̳߳ء��������,�Ǻ����̳߳ػ���DEFAULT_KEEPALIVEMILLISʱ���ڻ��ա�
        ExecutorService executorService = Executors.newScheduledThreadPool(10);

    }
}
