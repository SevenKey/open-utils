package sevenkey.open.utils.designpatterns.build.factorymethod;

import sevenkey.open.utils.designpatterns.build.factorymethod.impl.FactoryImpl;
import sevenkey.open.utils.designpatterns.build.factorymethod.impl.FactoryImplV2;

/**
 * 工厂方法
 * 工厂方法是指定义工厂接口和产品接口，但如何创建实际工厂和实际产品被推迟到子类实现，从而使调用方只和抽象工厂与抽象产品打交道。
 *
 * @author weijianyu
 */
public interface Factory {

    /**
     * 产品版本1
     */
    FactoryImpl factoryImpl = new FactoryImpl();

    /**
     * 产品版本2
     */
    FactoryImplV2 factoryImplV2 = new FactoryImplV2();

    /**
     * 方法
     *
     * @param key
     * @return 产品
     */
    Product parse(String key);

    /**
     * 获取实现类
     *
     * @return 工厂子类
     */
    static Factory getInstance() {
        return factoryImpl;
//        return factoryImplV2;
    }
}
