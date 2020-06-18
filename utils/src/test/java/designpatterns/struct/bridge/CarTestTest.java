package designpatterns.struct.bridge;


import org.junit.Test;
import sevenkey.open.utils.designpatterns.struct.bridge.impl.BossCar;
import sevenkey.open.utils.designpatterns.struct.bridge.impl.ElectricEngine;
import sevenkey.open.utils.designpatterns.struct.bridge.impl.FuelEngine;
import sevenkey.open.utils.designpatterns.struct.bridge.impl.HybridEngine;

/**
 * @author weijianyu
 */
public class CarTestTest {

    @Test
    public void testBossCarWithHybridEngine() {
        BossCar bossCar = new BossCar(new HybridEngine());
        bossCar.drive();
    }

    @Test
    public void testBossCarWithFuelEngine() {
        BossCar bossCar = new BossCar(new FuelEngine());
        bossCar.drive();
    }

    @Test
    public void testBossCarWithElectricEngine() {
        BossCar bossCar = new BossCar(new ElectricEngine());
        bossCar.drive();
    }
}
