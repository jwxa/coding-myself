package com.github.jwxa.designpattern.behavioral.templatemethod;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/6/13.
 */
public class Plus extends AbstractCalculator {
    @Override
    public int calculate(int num1, int num2) {
        return num1+num2;
    }
}
