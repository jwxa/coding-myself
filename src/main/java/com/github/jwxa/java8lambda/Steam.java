package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 流<br>
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
        //如果我们只想把蓝色改成红色：
        shapes.stream().filter(s->s.getColor()==Color.BLUE).forEach(s->s.setColor(Color.RED));
        System.out.println(shapes);
        //如果我们想把蓝色的形状提取到新的 List 里，则可以：
        List<Shape> blueShapeList = shapes.stream().filter(s -> s.getColor() == Color.BLUE).collect(Collectors.toList());
        System.out.println(blueShapeList);

        //如果每个形状都被保存在 Box 里，然后我们想知道哪个盒子至少包含一个蓝色形状，我们可以这么写：
        Set<Box> hasBlueShape = shapes.stream().filter(s->s.getColor()==Color.BLUE).map(s->s.getContainingBox()).collect(Collectors.toSet());

        //如果我们需要得到蓝色物体的总重量，我们可以这样表达：
        int sumWeight = shapes.stream().filter(s->s.getColor()==Color.BLUE).mapToInt(s->s.getWeight()).sum();


    }
}
