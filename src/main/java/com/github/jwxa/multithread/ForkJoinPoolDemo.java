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
        //����һ���߳���Ϊ2���̳߳�
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
//���Զ����̳߳�����ʵ�ֲ��м���������ʡ����PrimesPrint::isPrimeԴ��
        forkJoinPool.submit(() ->
                        //parallel task here, for example
                {
                    List<String> collect = IntStream.range(1, 1_000_000).parallel().mapToObj(String::valueOf).collect(Collectors.toList());
                    return collect;
                }
        ).get();
    }
}
