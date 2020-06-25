package sevenkey.open.utils.designpatterns.action.chain.impl;

import sevenkey.open.utils.designpatterns.action.chain.Handler;
import sevenkey.open.utils.designpatterns.action.chain.request.Request;

/**
 * @author weijianyu
 */
public class CEOHandler implements Handler {

    @Override
    public Boolean process(Request request) {
        return true;
    }
}
