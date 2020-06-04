package sevenkey.open.utils.designpatterns.build.factorymethod.impl;

import sevenkey.open.utils.designpatterns.build.factorymethod.Product;

/**
 * @author weijianyu
 */
public class ProductImplV2 implements Product {
    @Override
    public String say() {
        return "hello productImplV2";
    }
}
