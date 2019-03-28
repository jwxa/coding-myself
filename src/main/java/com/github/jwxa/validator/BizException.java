package com.github.jwxa.validator;

/**
 * �쳣
 * <p>
 * User: wen Date: 2015/08/06 Project: ecurreccy-bestpaycard-trade Version: 1.0
 */
public class BizException extends BaseException {

    /**
     * 1���ṩ�쳣����쳣Դ�����쳣
     *
     * @param errorCode
     * @param cause
     */
    public BizException(ErrorCode errorCode, Throwable cause) {
        this(errorCode, null, cause);
    }

    /**
     * 2���ṩ�쳣����쳣Դ�Ͷ��ⲹ����Ϣ�����쳣
     *
     * @param errorCode
     * @param extraMsg
     * @param cause
     */
    public BizException(ErrorCode errorCode, String extraMsg, Throwable cause) {
        super(errorCode, extraMsg, cause);
    }

    /**
     * 3���ṩ�쳣�빹���쳣
     *
     * @param errorCode
     */
    public BizException(ErrorCode errorCode) {
        this(errorCode, null, null);
    }

    /**
     * �ṩ�쳣��Ͷ��ⲹ����Ϣ�����쳣
     *
     * @param errorCode
     * @param extraMsg
     */
    public BizException(ErrorCode errorCode, String extraMsg) {
        this(errorCode, extraMsg, null);
    }

}
