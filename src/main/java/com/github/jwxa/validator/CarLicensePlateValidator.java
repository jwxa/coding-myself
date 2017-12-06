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
public class CarLicensePlateValidator extends ValidatorHandler<String> implements Validator<String> {

    @Override
    public boolean validate(ValidatorContext context, String t) {
        if (!"jwxa".equals(t)) {
            MyOwnValidationError validationError = new MyOwnValidationError();
            validationError.setBizErrorCode(BizErrorCode.LICENSE_NOT_JWXA.getCode());
            validationError.setBizErrorMsg(BizErrorCode.LICENSE_NOT_JWXA.getDesc());
            context.addError(validationError);
            return false;
        }
        return true;
    }

}
