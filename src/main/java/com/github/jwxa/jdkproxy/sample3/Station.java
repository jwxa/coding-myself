package com.github.jwxa.jdkproxy.sample3;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/31 ProjectName: coding-myself Version: 1.0
 */
public class Station implements TicketService {
    public void inquire() {
        System.out.println("问询");
    }

    public void sellTicket() {
        System.out.println("售票");
    }

    public void withdraw() {
        System.out.println("退票");
    }
}
