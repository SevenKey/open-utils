package designpatterns.build.factorymethod;

import org.junit.Test;
import sevenkey.open.utils.designpatterns.build.factorymethod.Factory;
import sevenkey.open.utils.designpatterns.build.factorymethod.Product;

public class FactoryMethodTest {

    @Test
    public void test() {
        Factory factory = Factory.getInstance();
        Product product = factory.parse("key");
        System.out.println(product.say());
    }
}
