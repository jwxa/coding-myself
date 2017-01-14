package com.github.jwxa.java8lambda.article1;

import java.util.Arrays;
import java.util.List;

/**
 * �ڲ��������ⲿ����<br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class InternalVsExternalIteration {
    public static void main(String[] args) {
        //�ⲿ������for-each ѭ������ shapes �� iterator() �����������α�����
        List<Shape> shapes = Arrays.asList(new Shape());
        for (Shape shape : shapes) {
            shape.setColor(Color.RED);
        }
        //���ǿ���ʹ�� �ڲ�������internal iteration������ⲿ�������û��ѶԵ����Ŀ���Ȩ������⣬������⴫�ݵ���ʱ����ִ�еĴ��롣
        shapes.forEach(s -> s.setColor(Color.RED));
        //���ܿ�����ֻ��һ��СС���﷨�Ķ����������ǵ�ʵ�ʲ��ǳ��޴�
        //�û��ѶԲ����Ŀ���Ȩ��������⣬�Ӷ����������и��ָ������Ż�����������ִ�С�������ֵ�Ͳ��еȵȣ����ܵ���˵���ڲ�����ʹ���ⲿ�����в�����ʵ�ֵ��Ż���Ϊ���ܡ�
    }

}
class Shape{
    private Color color;

    private Box containingBox;

    private int weight;


    public Shape(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape(Color color) {
        this.color = color;
    }

    public Shape() {
    }

    public Color getColor() {
        return color;
    }

    public Box getContainingBox() {
        return containingBox;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Shape{");
        sb.append("color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
enum Color{
    RED("RED"),BLUE("BLUE"),GREEN("GREEN");
    private String color;

    Color(String color) {
        this.color = color;
    }
}
class Box{

}
