package com.github.jwxa.validator;

import com.bestpay.exception.BaseException;
import com.bestpay.exception.ErrorCode;

/**
 * 异常
 *
 * User: wen Date: 2015/08/06 Project: ecurreccy-bestpaycard-trade Version: 1.0
 */
public class BizException extends BaseException {

    /**
     * 1、提供异常码和异常源构造异常
     * @param errorCode
     * @param cause
     */
    public BizException(ErrorCode errorCode, Throwable cause) {
        this(errorCode, null, cause);
    }

    /**
     * 2、提供异常码和异常源和额外补充信息构造异常
     * @param errorCode
     * @param extraMsg
     * @param cause
     */
    public BizException(ErrorCode errorCode, String extraMsg, Throwable cause) {
        super(errorCode, extraMsg, cause);
    }

    /**
     * 3、提供异常码构造异常
     * @param errorCode
     */
    public BizException(ErrorCode errorCode) {
        this(errorCode, null, null);
    }

    /**
     * 提供异常码和额外补充信息构造异常
     * @param errorCode
     * @param extraMsg
     */
    public BizException(ErrorCode errorCode, String extraMsg) {
        this(errorCode, extraMsg, null);
    }

}
