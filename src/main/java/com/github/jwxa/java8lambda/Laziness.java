package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ����<br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class Laziness {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Shape blueShape = new Shape(Color.BLUE,1);
        Shape redShape = new Shape(Color.RED,2);
        Shape greenShape = new Shape(Color.GREEN,3);
        shapes.add(blueShape);
        shapes.add(greenShape);
        shapes.add(redShape);
        // ����Ĺ��˲�����ӳ������Ƕ��Եģ�����ζ���ڵ��� sum() ֮ǰ�����ǲ��������Դ��ȡ�κ�Ԫ�ء�
        // �� sum ������ʼ֮�����ǰѹ��ˡ�ӳ���Լ���ͻ���ڶ�����Դ��һ�����֮�С��������Դ�����ά���м����������Ŀ�����
        // �� Streams API �У�����������Ĳ������Ƕ��Բ����������ط�������Ĳ����������޷���ֵ�Ĳ��������� forEach()�����Ǽ��Բ���
        int sumWeight = shapes.stream().filter(s->s.getColor()==Color.BLUE).mapToInt(s->s.getWeight()).sum();
        System.out.println(sumWeight);

        // ���� anyMatch(Predicate) �� findFirst() ��Щ������ֵ������
        // ���ǿ���ʹ�ö�·��short-circuiting������ֹ����Ҫ�����㡣���������ˮ��Ϊ����
        Optional<Shape> firstBlue = shapes.stream().filter(s->s.getColor()==Color.BLUE).findFirst();
//        if(firstBlue.isPresent())
//            System.out.println(firstBlue.get());
        firstBlue.ifPresent(s->System.out.print(s));
    }

}
