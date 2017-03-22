package com.github.jwxa.threadpool.part2;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个Java线程池的简单实现
 * <p>
 * http://blog.luoyuanhang.com/2017/03/15/thread-pool-in-java-3/
 * </p>
 * User: Jwxa Date: 2017/3/22 ProjectName: coding-myself Version: 1.0
 */
public class ThreadPoolManager extends ThreadGroup {

    int isThreadPoolValid = 0;//启动标志

    int sizeOfPoolThread = SystemConfig.getThreadPoolMaxSize();//线程池大小

    List<Task> taskList = new ArrayList<>();//任务队列

    public ThreadPoolManager(String threadpoolname){
        super(threadpoolname);
        setDaemon(true);
    }

    public synchronized void startThreadPool(){
        if(sizeOfPoolThread==0||isThreadPoolValid!=0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        if(taskList==null){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        for (int i = 0; i < sizeOfPoolThread; i++) {
             new WorkThread(i).start();
        }
        isThreadPoolValid=1;//启动标志
    }

    public synchronized void stopThreadPool(){
        if(sizeOfPoolThread==0||isThreadPoolValid!=0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        if(taskList==null){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        taskList.clear();
        sizeOfPoolThread=0;
        isThreadPoolValid=0;
        interrupt();
    }


    public synchronized void addTask(Task newTask){
        if(taskList==null){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        taskList.add(newTask);
        notify();
    }

    public synchronized Task getTask(){
        if(taskList==null){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        while(taskList.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return taskList.remove(0);
    }





    private class WorkThread extends Thread{
        public WorkThread(int threadID){
            super(ThreadPoolManager.this, ""+threadID);
        }

        public void run(){
            while(!isInterrupted()){
                Task runTask = getTask();

                if(runTask == null)
                    break;
                runTask.run();
            }
        }
    }

}


