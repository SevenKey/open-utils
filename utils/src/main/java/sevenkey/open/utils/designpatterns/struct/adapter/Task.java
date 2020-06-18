package sevenkey.open.utils.designpatterns.struct.adapter;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "hello callable";
    }
}
