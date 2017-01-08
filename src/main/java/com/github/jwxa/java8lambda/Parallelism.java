package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 并行<br>
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
        // 1.流水线既可以串行执行也可以并行执行，并行或串行是流的属性。除非你显式要求使用并行流，否则JDK总会返回串行流。
        //（串行流可以通过 parallel() 方法被转化为并行流）
        // 2.因为流的数据源可能是一个可变集合，如果在遍历流时数据源被修改，就会产生干扰（interference）。
        // 所以在进行流操作时，流的数据源应保持不变（held constant）。
        // 如果集合在遍历时被修改，绝大多数的集合实现都会抛出ConcurrentModificationException
        int sumWeight = shapes.parallelStream().filter(s->s.getColor()==Color.BLUE).mapToInt(s->s.getWeight()).sum();
        System.out.println(sumWeight);





    }
}
