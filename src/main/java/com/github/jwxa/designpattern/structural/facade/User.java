package com.github.jwxa.designpattern.structural.facade;

/**
 * ���ģʽ��Ϊ�˽��������֮�ҵ�������ϵ�ģ���springһ�������Խ������֮��Ĺ�ϵ���õ������ļ��У������ģʽ���ǽ����ǵĹ�ϵ����һ��Facade���У�����������֮�����϶ȣ���ģʽ��û���漰���ӿڣ�������ͼ����������һ�����������������Ϊ����<br>
 * User: Jwxa<br>
 * Date: 2016/5/31.
 */
public class User {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
