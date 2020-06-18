package sevenkey.open.utils.designpatterns.struct.proxy;

/**
 * Proxy模式
 * <p>
 * 代理模式通过封装一个已有接口，并向调用方返回相同的接口类型，能让调用方在不改变任何代码的前提下增强某些功能（例如，鉴权、延迟加载、连接池复用等）。
 * 使用Proxy模式要求调用方持有接口，作为Proxy的类也必须实现相同的接口类型。
 *
 * @author weijianyu
 */
public class CarServiceProxy implements CarService {

    private CarServiceImpl carService = new CarServiceImpl();

    @Override
    public String drive() {
        System.out.println("ready");
        String result = carService.drive();
        System.out.println("over");
        return result;
    }
}
