package sevenkey.open.utils.designpatterns.action.chain;

import com.google.common.collect.Lists;
import sevenkey.open.utils.designpatterns.action.chain.request.Request;

import java.util.List;

/**
 * Chain of Responsibility
 * 责任链模式是一种把多个处理器组合在一起，依次处理请求的模式；
 * 责任链模式的好处是添加新的处理器或者重新排列处理器非常容易；
 * 责任链模式经常用在拦截、预处理请求等。
 *
 * @author weijianyu
 */
public class HandlerChain {

    private List<Handler> handlers = Lists.newArrayList();

    public void add(Handler handler) {
        handlers.add(handler);
    }


    public boolean process(Request request) {
        handlers.forEach(handler -> handler.process(request));

        for (Handler handler : handlers) {
            Boolean response = handler.process(request);
            if (null == response) {
                continue;
            }

            return response;
        }
        throw new RuntimeException("error");
    }
}
