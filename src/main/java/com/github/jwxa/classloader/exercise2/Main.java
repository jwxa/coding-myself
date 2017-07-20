package com.github.jwxa.classloader.exercise2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * java利用classloader实现热部署
 * blog.csdn.net/chaofanwei/article/details/12858523
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/6/26 ProjectName: coding-myself Version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
        int i=0;
        while(true){
            i++;
            String name="name" + i;
            String result=server.doWork(name);
            System.out.println(result);
            try {
                Thread.sleep(1000* 5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
