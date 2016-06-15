package com.github.jwxa.designpattern.behavioral.command;

/**
 * ����ģʽ��Ŀ�ľ��Ǵﵽ����ķ����ߺ�ִ����֮����ʵ�������ִ�зֿ�<br>
 * ����ģʽ�ܺ���⣬�ٸ����ӣ�˾��Ա������ʿ��ȥ�ɼ����飬����������ĽǶ������ǣ�˾��Ա�������ǣ����������������ݣ�������ʿ�������ʿ��ȥִ�С�������̺��ڣ������໥����κ�һ��������ȥ���������ˣ�ֻ��Ҫ�����Լ����¶����У�˾��ԱҪ���ǽ��������ȥ��ע����ʿ������ôʵ�ֵġ�   <br>
 * User: Jwxa<br>
 * Date: 2016/6/15.
 */
public class Test {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new MyCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }

}
