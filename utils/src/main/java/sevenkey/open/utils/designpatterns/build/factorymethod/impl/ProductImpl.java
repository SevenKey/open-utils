package sevenkey.open.utils.designpatterns.build.factorymethod.impl;

import sevenkey.open.utils.designpatterns.build.factorymethod.Product;

/**
 * @author weijianyu
 */
public class ProductImpl implements Product {
    @Override
    public String say() {
        return "hello productImpl";
    }
}
