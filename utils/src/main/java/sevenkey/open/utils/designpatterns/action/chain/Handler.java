package sevenkey.open.utils.designpatterns.action.chain;

import sevenkey.open.utils.designpatterns.action.chain.request.Request;

/**
 * Chain of Responsibility
 * 责任链模式是一种把多个处理器组合在一起，依次处理请求的模式；
 * 责任链模式的好处是添加新的处理器或者重新排列处理器非常容易；
 * 责任链模式经常用在拦截、预处理请求等。
 *
 * @author weijianyu
 */
public interface Handler {
    Boolean process(Request request);
}
