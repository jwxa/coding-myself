package com.github.jwxa.jvm.chapter3;

/**
 * 一次对象自我拯救的演示
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/13 ProjectName: coding-myself Version: 1.0
 */
public class FinalizeEscapeGC {

    private static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes, i'm still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize method executed !");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5s等待它
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no,i am dead");
        }
        //下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5s等待它
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no,i am dead");
        }


    }
}
