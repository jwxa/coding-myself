package com.github.jwxa.jdkproxy.sample4;

/**
 * ������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/1 ProjectName: coding-myself Version: 1.0
 */
public class ElectricCar implements Rechargable,Vehicle {
    public void drive() {
        System.out.println("Electric Car is Moving silently...");
    }

    public void recharge() {
        System.out.println("Electric Car is Recharging...");
    }
}
