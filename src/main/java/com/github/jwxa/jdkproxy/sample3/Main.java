package com.github.jwxa.jdkproxy.sample3;

/**
 * 默认代理模式
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/31 ProjectName: coding-myself Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Station station = new Station();
        TicketService stationProxy = new StationProxy(station);
        stationProxy.sellTicket();
    }
}
