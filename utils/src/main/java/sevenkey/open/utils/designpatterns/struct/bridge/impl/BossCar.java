package sevenkey.open.utils.designpatterns.struct.bridge.impl;

import sevenkey.open.utils.designpatterns.struct.bridge.Car;
import sevenkey.open.utils.designpatterns.struct.bridge.Engine;

/**
 * @author weijianyu
 */
public class BossCar extends Car {
    public BossCar(Engine engine) {
        super(engine);
    }

    @Override
    public String getBrand() {
        return "bossCar";
    }
}
