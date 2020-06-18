package designpatterns.struct.facade;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.designpatterns.struct.facade.CompanyFacade;
import sevenkey.open.utils.designpatterns.struct.facade.bo.Company;

/**
 * @author weijianyu
 */
public class CompanyFacadeTest {

    @Test
    public void test() {
        CompanyFacade facade = new CompanyFacade();
        Company company = facade.openCompany("秋名山AE86");
        Assert.assertNotNull(company);
        Assert.assertEquals(1, company.getId());
        Assert.assertEquals("秋名山AE86", company.getName());
        Assert.assertEquals("zhangsan", company.getAccount());
        Assert.assertEquals("zhangsan001", company.getTaxCode());
    }
}
