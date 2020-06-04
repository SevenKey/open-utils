package sevenkey.open.utils.designpatterns.build.abstractmethod;

import sevenkey.open.utils.designpatterns.build.abstractmethod.impl.MFactory;
import sevenkey.open.utils.designpatterns.build.abstractmethod.impl.NFactory;

/**
 * 抽象工厂模式是为了让创建工厂和一组产品与使用相分离，并可以随时切换到另一个工厂以及另一组产品。
 * 抽象工厂模式实现的关键点是定义工厂接口和产品接口，但如何实现工厂与产品本身需要留给具体的子类实现，客户端只和抽象工厂与抽象产品打交道。
 *
 * @author weijianyu
 */
public interface AbstractFactory {

    MFactory mFactory = new MFactory();
    NFactory nFactory = new NFactory();

    /**
     * merge
     *
     * @return ProductA
     */
    ProductA merge();

    /**
     * pull
     *
     * @return ProductB
     */
    ProductB pull();

    /**
     * 获取工厂实例
     *
     * @param key key
     * @return AbstractFactory
     */
    static AbstractFactory getInstance(String key) {
        switch (key) {
            case "m":
                return mFactory;
            case "n":
                return nFactory;
            default:
                throw new IllegalArgumentException("fail");
        }
    }
}
