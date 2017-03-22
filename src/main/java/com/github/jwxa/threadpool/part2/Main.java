package com.github.jwxa.threadpool.part2;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/3/22 ProjectName: coding-myself Version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        ThreadPoolManager manager = new ThreadPoolManager("SimplePool");
        manager.startThreadPool();
        for(int i=0;i<5;i++){
            Task task = new TestTask(i);
            manager.addTask(task);
        }

    }

}
class TestTask extends Task{
    private int i ;

    public TestTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("Task "+ i+ " is running");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}