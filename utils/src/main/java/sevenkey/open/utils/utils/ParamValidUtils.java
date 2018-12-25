package sevenkey.open.utils.utils;


import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import sevenkey.open.utils.exception.ParamException;

import javax.validation.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 通用入参校验
 *
 * @author weijianyu
 */
public class ParamValidUtils {

    private ParamValidUtils() {
    }

    /**
     * controller层参数校验
     * 组装入参校验的错误信息并且返回
     *
     * @param bindingResult void
     */
    public static void combErrorAllMessage(BindingResult bindingResult) throws ParamException{
        if (!bindingResult.hasErrors()) {
            return;
        }
        StringBuilder error = new StringBuilder();
        for (ObjectError objectErrors : bindingResult.getAllErrors()) {
            error.append(objectErrors.getDefaultMessage()).append(" ");
        }
        throw new ParamException(error.toString());
    }

    /**
     * 通用参数校验 jsr 380 规则
     *
     * @param param 校验参数
     * @param <T>   泛型
     * @throws ParamException 自定义非运行时参数异常
     */
    public static <T> void commonParamValid(@Valid T param) throws ParamException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(param);
        Iterator<ConstraintViolation<T>> iter = violations.iterator();
        StringBuilder error = new StringBuilder();
        if (iter.hasNext()) {
            String errMessage = iter.next().getMessage();
            error.append(errMessage).append(" ");
        }
        if (StringUtils.isNotBlank(error.toString())) {
            throw new ParamException(error.toString());
        }
    }
}
