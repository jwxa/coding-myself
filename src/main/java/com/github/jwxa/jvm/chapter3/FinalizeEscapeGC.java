package com.github.jwxa.jvm.chapter3;

/**
 * һ�ζ����������ȵ���ʾ
 * <p>
 * ���������б�
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
        //�����һ�γɹ������Լ�
        SAVE_HOOK = null;
        System.gc();
        //��Ϊfinalize�������ȼ��ܵͣ�������ͣ0.5s�ȴ���
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no,i am dead");
        }
        //������δ������������ȫ��ͬ����������Ծ�ȴʧ����
        SAVE_HOOK = null;
        System.gc();
        //��Ϊfinalize�������ȼ��ܵͣ�������ͣ0.5s�ȴ���
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no,i am dead");
        }


    }
}
