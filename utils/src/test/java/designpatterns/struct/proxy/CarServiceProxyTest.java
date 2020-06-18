package designpatterns.struct.proxy;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.designpatterns.struct.proxy.CarServiceProxy;

/**
 * @author weijianyu
 */
public class CarServiceProxyTest {

    @Test
    public void test() {
        CarServiceProxy proxy = new CarServiceProxy();
        String result = proxy.drive();
        Assert.assertEquals("drive car", result);
    }
}
