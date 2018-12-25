package sevenkey.open.utils.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sevenkey.open.utils.common.enums.ResponseEnum;
import sevenkey.open.utils.exception.ParamException;
import sevenkey.open.utils.model.body.ParamTestBody;
import sevenkey.open.utils.model.vo.ResponseVO;
import sevenkey.open.utils.utils.ParamValidUtils;

import javax.validation.Valid;

/**
 * 参数校验controller
 *
 * @author weijianyu
 */
@RestController
public class ParamValidController {
    private static final Logger logger = LoggerFactory.getLogger(ParamValidController.class);

    @PostMapping(value = "param/valid")
    public ResponseVO<String> paramValid(@Valid @RequestBody ParamTestBody body, BindingResult result) throws ParamException {
        ParamValidUtils.combErrorAllMessage(result);
        logger.info("request log param/valid body:{}", body);
        ResponseVO<String> response = new ResponseVO<>();
        return response.success(ResponseEnum.SUCCESS, ResponseEnum.SUCCESS.getMessage());
    }
}
