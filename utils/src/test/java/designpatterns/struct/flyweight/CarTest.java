package designpatterns.struct.flyweight;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.designpatterns.struct.flyweight.Car;

/**
 * @author weijianyu
 */
public class CarTest {

    @Test
    public void test() {
        Assert.assertEquals(Car.createCar(1L, "AE86"), Car.createCar(1L, "AE86"));
        Assert.assertNotEquals(Car.createCar(2L, "SSR775"), Car.createCar(1L, "AE86"));
    }
}
