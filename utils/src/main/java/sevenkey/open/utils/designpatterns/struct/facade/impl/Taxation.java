package sevenkey.open.utils.designpatterns.struct.facade.impl;

import lombok.extern.slf4j.Slf4j;

/**
 * @author weijianyu
 */
@Slf4j
public class Taxation {
    /**
     * 纳税登记
     *
     * @param companyId 公司 id
     * @return 纳税登记号
     */
    public String applyTaxCode(long companyId) {
        log.info("companyId:{} create tax code success", companyId);
        return "zhangsan001";
    }
}
