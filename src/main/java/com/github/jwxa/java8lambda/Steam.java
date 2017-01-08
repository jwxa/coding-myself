package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ��<br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class Steam {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Shape blueShape = new Shape(Color.BLUE);
        Shape redShape = new Shape(Color.RED);
        Shape greenShape = new Shape(Color.GREEN);
        shapes.add(blueShape);
        shapes.add(greenShape);
        shapes.add(redShape);
        //�������ֻ�����ɫ�ĳɺ�ɫ��
        shapes.stream().filter(s->s.getColor()==Color.BLUE).forEach(s->s.setColor(Color.RED));
        System.out.println(shapes);
        //������������ɫ����״��ȡ���µ� List �����ԣ�
        List<Shape> blueShapeList = shapes.stream().filter(s -> s.getColor() == Color.BLUE).collect(Collectors.toList());
        System.out.println(blueShapeList);

        //���ÿ����״���������� Box �Ȼ��������֪���ĸ��������ٰ���һ����ɫ��״�����ǿ�����ôд��
        Set<Box> hasBlueShape = shapes.stream().filter(s->s.getColor()==Color.BLUE).map(s->s.getContainingBox()).collect(Collectors.toSet());

        //���������Ҫ�õ���ɫ����������������ǿ���������
        int sumWeight = shapes.stream().filter(s->s.getColor()==Color.BLUE).mapToInt(s->s.getWeight()).sum();


    }
}
