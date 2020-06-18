package designpatterns.build.singleton;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.designpatterns.build.singleton.Singleton;

/**
 * @author weijianyu
 */
public class SingletonTest {

    @Test
    public void test() {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();
        Singleton obj4 = Singleton.getInstance();

        Assert.assertEquals(obj1,obj2);
        Assert.assertEquals(obj2,obj3);
        Assert.assertEquals(obj3,obj4);
    }
}
