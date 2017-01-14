package com.github.jwxa.java8lambda.article1;

import java.util.Arrays;
import java.util.List;

/**
 * 内部迭代和外部迭代<br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class InternalVsExternalIteration {
    public static void main(String[] args) {
        //外部迭代：for-each 循环调用 shapes 的 iterator() 方法进行依次遍历。
        List<Shape> shapes = Arrays.asList(new Shape());
        for (Shape shape : shapes) {
            shape.setColor(Color.RED);
        }
        //我们可以使用 内部迭代（internal iteration）替代外部迭代，用户把对迭代的控制权交给类库，并向类库传递迭代时所需执行的代码。
        shapes.forEach(s -> s.setColor(Color.RED));
        //尽管看起来只是一个小小的语法改动，但是它们的实际差别非常巨大。
        //用户把对操作的控制权交还给类库，从而允许类库进行各种各样的优化（例如乱序执行、惰性求值和并行等等）。总的来说，内部迭代使得外部迭代中不可能实现的优化成为可能。
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
