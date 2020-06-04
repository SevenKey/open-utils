package sevenkey.open.utils.designpatterns.build.abstractmethod.impl;

import sevenkey.open.utils.designpatterns.build.abstractmethod.AbstractFactory;

/**
 * @author weijianyu
 */
public class MFactory implements AbstractFactory {

    @Override
    public ProductA1 merge() {
        return new ProductA1();
    }

    @Override
    public ProductB1 pull() {
        return new ProductB1();
    }
}
