package sevenkey.open.utils.designpatterns.struct.facade.impl;

import sevenkey.open.utils.designpatterns.struct.facade.bo.Company;

/**
 * @author weijianyu
 */
public class AdminOfIndustry {
    /**
     * 注册
     *
     * @param name 公司名称
     * @return 返回公司实体
     */
    public Company register(String name) {
        Company company = new Company();
        company.setId(1L);
        company.setName(name);
        return company;
    }
}
