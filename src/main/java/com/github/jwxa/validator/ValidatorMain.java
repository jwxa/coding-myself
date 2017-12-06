package com.github.jwxa.validator;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.bestpay.exception.ErrorCode;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/12/6 ProjectName: coding-myself Version: 1.0
 */
public class ValidatorMain {
    public static void main(String[] args) {
        Car car = new Car();
        car.setLicensePlate("jwxa");
        ComplexResult ret = FluentValidator.checkAll()
                .on(car.getLicensePlate(), new CarLicensePlateValidator())
                .on(car.getManufacturer(), new CarManufacturerValidator())
                .on(car.getSeatCount(), new CarSeatCountValidator())
                .failFast()//快速失败
//                .failOver()//全部校验
                .doValidate()
                .result(toComplex());
        System.out.println(ret);
        if(!ret.isSuccess()){
            throw new BizException(transErrors((MyOwnValidationError) ret.getErrors().get(0)));
        }
    }

    private static ErrorCode transErrors(MyOwnValidationError validationError) {
        return new ErrorCode() {
            @Override
            public String getCode() {
                return validationError.getBizErrorCode();
            }

            @Override
            public String getDesc() {
                return validationError.getBizErrorMsg();
            }
        };
    }
}
