package com.github.jwxa.test;

import java.util.Calendar;

/**
 * ����
 * User: Jwxa
 * Date: 2016/4/13.
 */
public class Test {

    public static int getAgeByIdCard(String idCard) {
        int iAge = 0;
        String year = idCard.substring(6, 10);
        if(!isNum(year)){
            return iAge;
        }
        Calendar cal = Calendar.getInstance();
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }

    /**
     * ������֤
     *
     * @param val
     * @return ��ȡ�����֡�
     */
    public static boolean isNum(String val) {
        return val == null || "".equals(val) ? false : val.matches("^[0-9]*$");
    }


    public static void main(String[] args) {
        System.out.println(getAgeByIdCard("513032196406060523"));
    }
}
