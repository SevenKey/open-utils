package sevenkey.open.utils.designpatterns.action.chain.impl;

import org.apache.commons.lang3.StringUtils;
import sevenkey.open.utils.designpatterns.action.chain.Handler;
import sevenkey.open.utils.designpatterns.action.chain.request.Request;

import java.math.BigDecimal;

/**
 * @author weijianyu
 */
public class DirectorHandler implements Handler {

    @Override
    public Boolean process(Request request) {
        if (request.getAccount().compareTo(BigDecimal.valueOf(1000.0)) >= 1) {
            System.out.println("DirectorHandler can not deal");
            return null;
        }

        return !StringUtils.equals("Jiny", request.getName());
    }
}