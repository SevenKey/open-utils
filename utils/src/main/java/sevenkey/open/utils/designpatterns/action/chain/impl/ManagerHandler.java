package sevenkey.open.utils.designpatterns.action.chain.impl;

import org.apache.commons.lang3.StringUtils;
import sevenkey.open.utils.designpatterns.action.chain.Handler;
import sevenkey.open.utils.designpatterns.action.chain.request.Request;

import java.math.BigDecimal;

/**
 * @author weijianyu
 */
public class ManagerHandler implements Handler {

    @Override
    public Boolean process(Request request) {
        if (request.getAccount().compareTo(BigDecimal.valueOf(100.0)) >= 1) {
            System.out.println("ManagerHandler can not deal");
            return null;
        }

        return !StringUtils.equals("Tom", request.getName());
    }
}
