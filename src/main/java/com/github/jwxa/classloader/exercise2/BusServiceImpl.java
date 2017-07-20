//package com.github.jwxa.classloader.exercise2;
//
//import java.util.Date;
//
///**
// * 类描述
// * <p>
// * 方法描述列表
// * </p>
// * User: Jwxa Date: 2017/6/26 ProjectName: coding-myself Version: 1.0
// */
//public class BusServiceImpl implements BusService {
//    volatile boolean close = false;
//    Date date= new Date();
//    String version ="2.0";
//    {
//        Thread thread = new Thread(){
//            public void run() {
//                setName("busServiceImplThread:"+date.toLocaleString());
//                System.out.println(this.toString() + ",time:"+date.toLocaleString());
//                System.out.println(close);
//                while(!close){
//                    doIt("");
//                    try {
//                        System.out.println(getName() + ",org time:"+date.toLocaleString() + "  ,curtime:"+ new Date().toLocaleString());
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                        Thread.currentThread().interrupt();
//                    }
//                }
//
//            };
//        };
//        thread.start();
//    }
//    @Override
//    public String doIt(String name) {
//        String res = version + " " + name+ " ,hello";
//        return res;
//    }
//    @Override
//    public void close() {
//        close = true;
//        System.out.println("close invoked !,"+this.toString() + ",time:"+date.toLocaleString());
//    }
//}
