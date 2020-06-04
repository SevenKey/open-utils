package sevenkey.open.utils.designpatterns.build.factorymethod.impl;


import sevenkey.open.utils.designpatterns.build.factorymethod.Factory;

/**
 * @author weijianyu
 */
public class FactoryImpl implements Factory {

    @Override
    public ProductImpl parse(String key) {
        return new ProductImpl();
    }

}
