package com.github.jwxa.thinkinginjava.chapter4;

/**
 * ��ǩ����forѭ��������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/11 ProjectName: coding-myself Version: 1.0
 */
public class LabeledFor {

    public static void main(String[] args) {
        int i =0;
        outer:
        for(;true;){
            inner:
            for(;i<10;i++){
                System.out.println("i= "+i);
                if(i==2){
                    System.out.println("continue");
                    continue ;
                }
                if(i==3){
                    System.out.println("break");
                    i++;//������iһֱ��3 ��ѭ��
                    break ;
                }
                if(i==7){
                    System.out.println("continue outer");
                    i++;//������iһֱ��7 ��ѭ��
                    continue outer;
                }
                if(i==8){
                    System.out.println("break outer");
                    break outer;
                }
                for(int k=0;k<5;k++){
                    if(k==3){
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
}
