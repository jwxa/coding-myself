package com.github.jwxa.designpattern.structural.proxy;

/**
 * ����ģʽ<br>
 *
 * ����ģʽ��Ӧ�ó�����<br>

 ������еķ�����ʹ�õ�ʱ����Ҫ��ԭ�еķ������иĽ�����ʱ�����ְ취��<br>

 1���޸�ԭ�еķ�������Ӧ������Υ���ˡ�����չ���ţ����޸Ĺرա���ԭ��<br>

 2�����ǲ���һ�����������ԭ�еķ������ҶԲ����Ľ�����п��ơ����ַ������Ǵ���ģʽ��<br>

 ʹ�ô���ģʽ�����Խ����ܻ��ֵĸ��������������ں���ά����<br>

 * User: Jwxa<br>
 * Date: 2016/5/10.
 */
public class Client {

    public static void main(String[] args) {
        Sourceable sourceable = new Proxy();
        sourceable.method();
    }
}
