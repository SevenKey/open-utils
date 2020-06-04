package designpatterns.build.abstractmethod;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.designpatterns.build.abstractmethod.AbstractFactory;
import sevenkey.open.utils.designpatterns.build.abstractmethod.ProductA;
import sevenkey.open.utils.designpatterns.build.abstractmethod.ProductB;

public class AbstractFactoryTest {

    @Test
    public void test() {
        AbstractFactory abstractFactory;
        ProductA productA;
        ProductB productB;

        abstractFactory = AbstractFactory.getInstance("m");
        productA = abstractFactory.merge();
        productB = abstractFactory.pull();
        Assert.assertEquals("hello A1", productA.say());
        Assert.assertEquals("hello B1", productB.say());

        abstractFactory = AbstractFactory.getInstance("n");
        productA = abstractFactory.merge();
        productB = abstractFactory.pull();
        Assert.assertEquals("hello A2", productA.say());
        Assert.assertEquals("hello B2", productB.say());
    }
}
