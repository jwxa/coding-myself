package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/24 ProjectName: coding-myself Version: 1.0
 */
public class Practice12 {
    public static void main(String[] args) {
        Tank t = new Tank(false);
        t.setEmpty();
        new Tank(false);
        System.gc();
    }
}
class Tank{
    private boolean isEmpty = true;

    public Tank(boolean isEmpty){
        this.isEmpty = isEmpty;
    }

    public void setEmpty(){
        isEmpty=true;
    }

    @Override
    protected void finalize() throws Throwable {
        if(!isEmpty){
            System.out.println("is not empty , check!");
        }
    }
}
