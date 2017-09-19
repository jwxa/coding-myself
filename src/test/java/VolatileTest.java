import java.util.concurrent.TimeUnit;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/6/5 ProjectName: coding-myself Version: 1.0
 */
public class VolatileTest {

    private static volatile boolean stopThread;

    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopThread) {
                    i++;
//                    System.out.println(i);
                }
            }
        });
        th.start();
        TimeUnit.SECONDS.sleep(2);
        stopThread = true;
    }


}
