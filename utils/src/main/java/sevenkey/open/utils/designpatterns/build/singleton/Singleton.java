package sevenkey.open.utils.designpatterns.build.singleton;

/**
 * 单例模式
 * Singleton模式是为了保证一个程序的运行期间，某个类有且只有一个全局唯一实例；
 * Singleton模式既可以严格实现，也可以以约定的方式把普通类视作单例。
 * <p>
 * 如果想要延时加载，需要加锁，但是加锁之后会影响并发性能影响，可以通过枚举来实现。
 *
 * @author weijianyu
 */
public class Singleton {

    /**
     * 通过 classLoader 保证只加载一次
     */
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    /**
     * 获取单例
     *
     * @return Singleton
     */
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
