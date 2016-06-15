package com.github.jwxa.designpattern.behavioral.state;

/**
 * ״̬ģʽ��State�� <br>
 * ����˼����ǣ��������״̬�ı�ʱ��ͬʱ�ı�����Ϊ���ܺ���⣡����QQ��˵���м���״̬�����ߡ�����æµ�ȣ�ÿ��״̬��Ӧ��ͬ�Ĳ�����������ĺ���Ҳ�ܿ������״̬�����ԣ�״̬ģʽ�����㣺1������ͨ���ı�״̬����ò�ͬ����Ϊ��2����ĺ�����ͬʱ������ı仯�� <br>
 * User: Jwxa<br>
 * Date: 2016/6/15.
 */
public class Test {

    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);
        state.setValue("state1");
        context.method();
        state.setValue("state2");
        context.method();
    }
}
