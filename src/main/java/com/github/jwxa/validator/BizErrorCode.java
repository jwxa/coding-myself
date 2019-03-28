package com.github.jwxa.validator;

/**
 * ������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/12/6 ProjectName: coding-myself Version: 1.0
 */
public enum BizErrorCode implements ErrorCode{

    MANUFACTURE_NOT_JWXA("E_AA0027","�����̲���jwxa"),
    LICENSE_NOT_JWXA("E_AA0027","���֤����jwxa"),
    SEAT_COUNT_NOT_ENOUGH("E_AA0027","��λ������%s");
    /**
     * �쳣��
     */
    private String code;

    /**
     * �쳣����
     */
    private String desc;

    BizErrorCode(String code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
