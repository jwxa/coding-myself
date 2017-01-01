package com.github.jwxa.jdkproxy.sample3;

/**
 * ������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2016/12/31 ProjectName: coding-myself Version: 1.0
 */
public class StationProxy implements TicketService {
    private Station station;

    public StationProxy(Station station) {
        this.station = station;
    }

    public void inquire() {
        // 1������ҵ��ǰ����ʾ��Ϣ
        this.showAlertInfo("����������ӭ���ٱ����۵㣬��ѯ���񲻻���ȡ�κη��ã�����ѯ��Ϣ�����ο���������Ϣ�Գ�վ��ʵ����Ϊ׼����������");
        // 2.������ʵ�߼�
        station.inquire();
        // 3������
        this.showAlertInfo("����������ӭ���Ĺ��٣��ټ�����������");

    }

    public void sellTicket() {
        // 1.������ҵ��ǰ����ʾ��Ϣ
        this.showAlertInfo("��������������ʹ�ó�Ʊ���۵���й�Ʊ��ÿ��Ʊ������ȡ5Ԫ�����ѣ���������");
        // 2.������ʵҵ���߼�
        station.sellTicket();
        // 3.����
        this.takeHandlingFee();
        this.showAlertInfo("����������ӭ���Ĺ��٣��ټ�����������");
    }

    public void withdraw() {
        // 1������ҵ��ǰ����
        this.showAlertInfo("����������ӭ���ٱ����۵㣬��Ʊ���˿۳�Ʊ���20%�⣬�������������2Ԫ�����ѣ���������");
        // 2.��������ҵ���߼�
        station.withdraw();
        // 3.����
        this.takeHandlingFee();
    }

    private void takeHandlingFee() {
        System.out.println("��ȡ�����ѣ���ӡ��Ʊ����������");
    }

    private void showAlertInfo(String info) {
        System.out.println(info);
    }


}
