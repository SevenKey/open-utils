package sevenkey.open.utils.designpatterns.struct.adapter;

/**
 * Adapter模式
 * Adapter模式可以将一个A接口转换为B接口，使得新的对象符合B接口规范。
 * 编写Adapter实际上就是编写一个实现了B接口，并且内部持有A接口的类.
 * 只有A、B接口均为抽象接口时，才能非常简单地实现Adapter模式。
 *
 * @author weijianyu
 */
public class RunnableAdapter implements Runnable {

    private Task task;

    public RunnableAdapter(Task task) {
        this.task = task;
    }

    public RunnableAdapter() {
    }

    @Override
    public void run() {
        try {
            System.out.println(task.call());
        } catch (Exception e) {
            throw new RuntimeException("runnable run callable Exception", e);
        }
    }
}
