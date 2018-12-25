package sevenkey.open.utils.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sevenkey.open.utils.common.enums.ResponseEnum;

/**
 * @author weijianyu
 */
@RestController
public class AliveController {
    private static final Logger logger = LoggerFactory.getLogger(AliveController.class);

    @GetMapping(value = "alive")
    public String alive() {
        logger.info("request log alive");
        return ResponseEnum.SUCCESS.getMessage();
    }
}
