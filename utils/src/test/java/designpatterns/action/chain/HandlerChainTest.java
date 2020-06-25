package designpatterns.action.chain;

import org.junit.Test;
import sevenkey.open.utils.designpatterns.action.chain.HandlerChain;
import sevenkey.open.utils.designpatterns.action.chain.impl.CEOHandler;
import sevenkey.open.utils.designpatterns.action.chain.impl.DirectorHandler;
import sevenkey.open.utils.designpatterns.action.chain.impl.ManagerHandler;
import sevenkey.open.utils.designpatterns.action.chain.request.Request;

import java.math.BigDecimal;

/**
 * @author weijianyu
 */
public class HandlerChainTest {

    @Test
    public void test() {
        HandlerChain chain = new HandlerChain();

        ManagerHandler managerHandler = new ManagerHandler();
        DirectorHandler directorHandler = new DirectorHandler();
        CEOHandler ceoHandler = new CEOHandler();

        chain.add(managerHandler);
        chain.add(directorHandler);
        chain.add(ceoHandler);

        Request request = new Request();
        request.setAccount(BigDecimal.valueOf(10));
        request.setName("AME");
        chain.process(request);

        request.setAccount(BigDecimal.valueOf(10));
        request.setName("Tom");
        chain.process(request);

        request.setAccount(BigDecimal.valueOf(200));
        request.setName("AME");
        chain.process(request);

        request.setAccount(BigDecimal.valueOf(200));
        request.setName("Tom");
        chain.process(request);

        request.setAccount(BigDecimal.valueOf(200));
        request.setName("Jimy");
        chain.process(request);

        request.setAccount(BigDecimal.valueOf(20000));
        request.setName("Tom");
        chain.process(request);

        request.setAccount(BigDecimal.valueOf(20000));
        request.setName("AME");
        chain.process(request);
    }
}
