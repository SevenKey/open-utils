package sevenkey.open.utils.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sevenkey.open.utils.aop.annotation.ZebraMaster;

/**
 * @author weijianyu
 */
@Service
public class ZebraService {
    private final Logger logger = LoggerFactory.getLogger(ZebraService.class);

    @ZebraMaster
    public int sum() {
        return 0;
    }
}
