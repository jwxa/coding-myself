package com.github.jwxa.algorithms;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/3/23.
 */
public class FindMaxDemo {
    public static Comparable findMax(Comparable[] arr){
        int maxIndex =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].compareTo(arr[maxIndex])>0){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    public static void main(String[] args) {
        Shape[] sh1 = {
                new Circle(2.0),
                new Square(3.0),
                new Rectangle(3.0,4.0)
        };
        String [] st1 = {"Joe","Bob","Bill","Zeke"};
        System.out.println(findMax(sh1));
        System.out.println(findMax(st1));
        Shape.totalArea(sh1);
    }
}

class Shape implements Comparable<Shape> {
    protected double area;

    public static double totalArea(Shape[] arr){
        double total =0;
        for(Shape s:arr){
            if(s!=null)
                total += s.area;
        }
        System.out.println(total);
        return total;
    }

    public int compareTo(Shape o) {
        if(area>o.area){
            return 1;
        }else{
            return 0;
        }
    }
}

class Circle extends Shape {

    public Circle(double value) {
        super.area = 3.14 * value*value;
        System.out.println(area);
    }
}

class Square extends Shape{

    public Square(double value) {
        super.area = value * value;
        System.out.println(area);
    }
}

class Rectangle extends Shape{

    public Rectangle(double value1, double value2) {
        super.area = value1*value2;
        System.out.println(area);
    }
}

