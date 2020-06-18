package sevenkey.open.utils.designpatterns.struct.facade.bo;

import lombok.Data;

/**
 * 公司实体
 *
 * @author weijianyu
 */
@Data
public class Company {

    private long id;

    private String name;

    private String account;

    private String taxCode;
}
