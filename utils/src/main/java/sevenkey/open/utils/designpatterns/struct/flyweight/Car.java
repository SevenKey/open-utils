package sevenkey.open.utils.designpatterns.struct.flyweight;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

/**
 * Flyweight模式
 * 如果一个对象实例一经创建就不可变，那么反复创建相同的实例就没有必要，直接向调用方返回一个共享的实例就行，这样即节省内存，又可以减少创建对象的过程，提高运行速度。
 * 享元模式的设计思想是尽量复用已创建的对象，常用于工厂方法内部的优化。
 *
 * @author weijianyu
 */
@Data
public class Car {

    private long id;

    private String name;

    private static final Map<Long, Car> MAPS = Maps.newHashMap();


    public Car(long id, String name) {
        this.name = name;
        this.id = id;
    }

    /**
     * 创建 car 如果存在直接返回
     *
     * @param id   id
     * @param name 名称
     * @return car
     */
    public static Car createCar(long id, String name) {
        Car cacheCar = MAPS.get(id);
        if (null == cacheCar) {
            Car car = new Car(id, name);
            MAPS.put(id, car);
            return car;
        }
        return cacheCar;
    }
}
