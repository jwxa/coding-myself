package com.github.jwxa.designpattern.behavioral.iterator;

/**
 * ����˼�壬������ģʽ����˳����ʾۼ��еĶ���һ����˵�������зǳ�����������Լ�����Ƚ���Ϥ�Ļ�����Ȿģʽ��ʮ�����ɡ���仰����������˼��һ����Ҫ�����Ķ��󣬼��ۼ����󣬶��ǵ������������ڶԾۼ�������б������ʡ�<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public class Test {

    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
