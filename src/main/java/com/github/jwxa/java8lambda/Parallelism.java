package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * ����<br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class Parallelism {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Shape blueShape = new Shape(Color.BLUE);
        Shape redShape = new Shape(Color.RED);
        Shape greenShape = new Shape(Color.GREEN);
        shapes.add(blueShape);
        shapes.add(greenShape);
        shapes.add(redShape);
        // 1.��ˮ�߼ȿ��Դ���ִ��Ҳ���Բ���ִ�У����л������������ԡ���������ʽҪ��ʹ�ò�����������JDK�ܻ᷵�ش�������
        //������������ͨ�� parallel() ������ת��Ϊ��������
        // 2.��Ϊ��������Դ������һ���ɱ伯�ϣ�����ڱ�����ʱ����Դ���޸ģ��ͻ�������ţ�interference����
        // �����ڽ���������ʱ����������ԴӦ���ֲ��䣨held constant����
        // ��������ڱ���ʱ���޸ģ���������ļ���ʵ�ֶ����׳�ConcurrentModificationException
        int sumWeight = shapes.parallelStream().filter(s->s.getColor()==Color.BLUE).mapToInt(s->s.getWeight()).sum();
        System.out.println(sumWeight);





    }
}
