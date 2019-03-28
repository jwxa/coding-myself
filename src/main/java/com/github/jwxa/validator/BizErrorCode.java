package com.github.jwxa.validator;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/12/6 ProjectName: coding-myself Version: 1.0
 */
public enum BizErrorCode implements ErrorCode{

    MANUFACTURE_NOT_JWXA("E_AA0027","制造商不是jwxa"),
    LICENSE_NOT_JWXA("E_AA0027","许可证不是jwxa"),
    SEAT_COUNT_NOT_ENOUGH("E_AA0027","座位数不足%s");
    /**
     * 异常码
     */
    private String code;

    /**
     * 异常描述
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
