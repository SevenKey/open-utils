package sevenkey.open.utils.designpatterns.struct.bridge.impl;

import sevenkey.open.utils.designpatterns.struct.bridge.Engine;

/**
 * @author weijianyu
 */
public class ElectricEngine implements Engine {
    @Override
    public String start() {
        System.out.println("electricEngine");
        return "electricEngine";
    }
}
