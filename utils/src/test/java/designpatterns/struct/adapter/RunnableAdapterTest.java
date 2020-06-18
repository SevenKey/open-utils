package designpatterns.struct.adapter;

import org.junit.Test;
import sevenkey.open.utils.designpatterns.struct.adapter.RunnableAdapter;
import sevenkey.open.utils.designpatterns.struct.adapter.Task;

/**
 * @author weijianyu
 */
public class RunnableAdapterTest {

    @Test
    public void test() {
        Task task = new Task();

        RunnableAdapter runnableAdapter = new RunnableAdapter(task);

//        Thread thread = new Thread(callable);
        Thread thread = new Thread(runnableAdapter);
        thread.start();
    }
}
