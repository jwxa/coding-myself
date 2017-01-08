package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 惰性<br>
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
        // 这里的过滤操作和映射操作是惰性的，这意味着在调用 sum() 之前，我们不会从数据源提取任何元素。
        // 在 sum 操作开始之后，我们把过滤、映射以及求和混合在对数据源的一遍遍历之中。这样可以大大减少维持中间结果所带来的开销。
        // 在 Streams API 中，返回流对象的操作都是惰性操作，而返回非流对象的操作（或者无返回值的操作，例如 forEach()）都是急性操作
        int sumWeight = shapes.stream().filter(s->s.getColor()==Color.BLUE).mapToInt(s->s.getWeight()).sum();
        System.out.println(sumWeight);

        // 对于 anyMatch(Predicate) 和 findFirst() 这些急性求值操作，
        // 我们可以使用短路（short-circuiting）来终止不必要的运算。以下面的流水线为例：
        Optional<Shape> firstBlue = shapes.stream().filter(s->s.getColor()==Color.BLUE).findFirst();
//        if(firstBlue.isPresent())
//            System.out.println(firstBlue.get());
        firstBlue.ifPresent(s->System.out.print(s));
    }

}
