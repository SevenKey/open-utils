package sevenkey.open.utils.designpatterns.build.abstractmethod.impl;

import sevenkey.open.utils.designpatterns.build.abstractmethod.ProductA;

/**
 * @author weijianyu
 */
public class ProductA1 implements ProductA {

    @Override
    public String say() {
        return "hello A1";
    }
}
