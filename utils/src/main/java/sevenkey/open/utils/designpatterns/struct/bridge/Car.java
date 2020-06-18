package sevenkey.open.utils.designpatterns.struct.bridge;

/**
 * 桥接模式通过分离一个抽象接口和它的实现部分，使得设计可以按两个维度独立扩展。
 *
 * @author weijianyu
 */
public abstract class Car {

    /**
     * 引擎
     */
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Car() {
    }

    /**
     * 品牌
     *
     * @return 品牌类型
     */
    public abstract String getBrand();

    /**
     * drive
     */
    public void drive() {
        engine.start();
        System.out.println("drive " + getBrand() + " car");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}

