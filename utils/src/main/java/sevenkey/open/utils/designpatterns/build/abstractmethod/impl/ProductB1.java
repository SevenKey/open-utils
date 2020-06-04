package sevenkey.open.utils.designpatterns.build.abstractmethod.impl;

import sevenkey.open.utils.designpatterns.build.abstractmethod.ProductB;

/**
 * @author weijianyu
 */
public class ProductB1 implements ProductB {

    @Override
    public String say() {
        return "hello B1";
    }
}
