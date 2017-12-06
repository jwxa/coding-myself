package com.github.jwxa.validator;

import com.baidu.unbiz.fluentvalidator.ValidationError;

/**
 * https://github.com/neoremind/fluent-validator
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/12/6 ProjectName: coding-myself Version: 1.0
 */
public class MyOwnValidationError extends ValidationError {

    private String bizErrorCode;

    private String bizErrorMsg;

    public String getBizErrorCode() {
        return bizErrorCode;
    }

    public void setBizErrorCode(String bizErrorCode) {
        this.bizErrorCode = bizErrorCode;
    }

    public String getBizErrorMsg() {
        return bizErrorMsg;
    }

    public void setBizErrorMsg(String bizErrorMsg) {
        this.bizErrorMsg = bizErrorMsg;
    }
}
