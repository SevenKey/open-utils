package sevenkey.open.utils.designpatterns.struct.facade.impl;

import lombok.extern.slf4j.Slf4j;

/**
 * @author weijianyu
 */
@Slf4j
public class Bank {
    /**
     * 银行开户
     *
     * @param companyId 公司 id
     * @return 结果
     */
    public String openAccount(long companyId) {
        log.info("companyId:{} open account success",companyId);
        return "zhangsan";
    }
}
