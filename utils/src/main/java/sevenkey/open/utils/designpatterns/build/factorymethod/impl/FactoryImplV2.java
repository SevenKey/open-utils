package sevenkey.open.utils.designpatterns.build.factorymethod.impl;


import sevenkey.open.utils.designpatterns.build.factorymethod.Factory;

/**
 * @author weijianyu
 */
public class FactoryImplV2 implements Factory {

    @Override
    public ProductImplV2 parse(String key) {
        return new ProductImplV2();
    }

}
