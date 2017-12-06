package com.github.jwxa.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/12/6 ProjectName: coding-myself Version: 1.0
 */
public class CarSeatCountValidator extends ValidatorHandler<Integer> implements Validator<Integer> {

    private static final String SEAT_COUNT_LIMIT = "2";

    @Override
    public boolean validate(ValidatorContext context, Integer t) {
        if (t < Integer.parseInt(SEAT_COUNT_LIMIT)) {
            MyOwnValidationError validationError = new MyOwnValidationError();
            validationError.setBizErrorCode(BizErrorCode.SEAT_COUNT_NOT_ENOUGH.getCode());
            validationError.setBizErrorMsg(String.format(BizErrorCode.SEAT_COUNT_NOT_ENOUGH.getDesc(),SEAT_COUNT_LIMIT));
            context.addError(validationError);
            return false;
        }
        return true;
    }
}
