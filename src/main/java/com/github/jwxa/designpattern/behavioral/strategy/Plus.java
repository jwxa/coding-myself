package com.github.jwxa.designpattern.behavioral.strategy;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/6/13.
 */
public class Plus extends AbstractCalculator implements ICalculator {
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\+");
        return arrayInt[0]+ arrayInt[1];
    }
}
