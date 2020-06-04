package sevenkey.open.utils.designpatterns.build.abstractmethod.impl;

import sevenkey.open.utils.designpatterns.build.abstractmethod.AbstractFactory;

/**
 * @author weijianyu
 */
public class NFactory implements AbstractFactory {

    @Override
    public ProductA2 merge() {
        return new ProductA2();
    }

    @Override
    public ProductB2 pull() {
        return new ProductB2();
    }
}
