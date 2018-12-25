package sevenkey.open.utils.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import sevenkey.open.utils.common.enums.ResponseEnum;
import sevenkey.open.utils.exception.ParamException;
import sevenkey.open.utils.model.vo.ResponseVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author weijianyu
 */
@ControllerAdvice
public class DefaultControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(DefaultControllerAdvice.class);

    @ExceptionHandler(value = ParamException.class)
    @ResponseBody
    public ResponseVO<String> dealParamValidException(ParamException e, HttpServletRequest request) {
        logger.info("controller param valid request:{} errorMessage:{}", request, e.getErrorMessage());
        ResponseVO<String> response = new ResponseVO<>();
        return response.fail(ResponseEnum.PARAM_FAIL, e.getErrorMessage());
    }
}
