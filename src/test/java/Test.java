import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * ������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/2/19 ProjectName: coding-myself Version: 1.0
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {
        final Object synObj = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (synObj) {
                    System.out.println("T1��ȡsynObj�Ķ������������ʼִ��ͬ����");
                    try {
                        TimeUnit.MINUTES.sleep(1);
                        System.out.println("T1�� wait()ʱ������");
                        synObj.wait();
                        System.out.println("T1��T2���Ѻ����»��synObj�Ķ��������������ִ��");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T1��ȡsynObj�Ķ��������������ͬ����");
                }
            }
        });

        t1.start();

        Collections.reverseOrder();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T2������������ΪT1ռ����synObj�Ķ������������ȴ�T1ִ��synObj.wait���ͷ���");
                synchronized(synObj) {
                    try {
                        System.out.println("��T1ִ��synObj.wait��T2��ȡsynObj�Ķ��������������ͬ����");
                        synObj.notify();
                        System.out.println("T2ִ��synObj.notify()��T1�����ѣ���T2����ͬ�����У�û���ͷ�synObj�Ķ����������T1�ȴ�synObj�Ķ��������");
                        TimeUnit.MINUTES.sleep(1);
                        System.out.println("T2����ͬ���飬�ͷ�synObj�Ķ����������T1��ȡ��synObj�Ķ������������ִ��wait����Ĳ���");
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        });
        t2.start();

    }

}


