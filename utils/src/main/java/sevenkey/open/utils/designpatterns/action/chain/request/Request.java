package sevenkey.open.utils.designpatterns.action.chain.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author weijianyu
 */
@Data
public class Request {

    private BigDecimal account;

    private String name;

}
