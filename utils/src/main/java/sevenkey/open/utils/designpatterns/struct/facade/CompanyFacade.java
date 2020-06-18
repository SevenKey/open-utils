package sevenkey.open.utils.designpatterns.struct.facade;

import sevenkey.open.utils.designpatterns.struct.facade.bo.Company;
import sevenkey.open.utils.designpatterns.struct.facade.impl.AdminOfIndustry;
import sevenkey.open.utils.designpatterns.struct.facade.impl.Bank;
import sevenkey.open.utils.designpatterns.struct.facade.impl.Taxation;

/**
 * Facade模式
 * Facade模式是为了给客户端提供一个统一入口，并对外屏蔽内部子系统的调用细节。
 *
 * @author weijianyu
 */
public class CompanyFacade {

    private AdminOfIndustry adminOfIndustry = new AdminOfIndustry();

    private Bank bank = new Bank();

    private Taxation taxation = new Taxation();

    /**
     * 开公司
     *
     * @param name 公司名称
     * @return 公司实体
     */
    public Company openCompany(String name) {
        Company company = adminOfIndustry.register(name);

        long companyId = company.getId();

        String account = bank.openAccount(companyId);
        company.setAccount(account);

        String taxCode = taxation.applyTaxCode(companyId);
        company.setTaxCode(taxCode);

        return company;
    }
}
