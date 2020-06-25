package designpatterns.action.interpreter;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.designpatterns.action.interpreter.Interpreter;
import sevenkey.open.utils.designpatterns.action.interpreter.impl.LogInterpreter;

/**
 * @author weijianyu
 */
public class InterpreterTest {

    @Test
    public void test(){
        Interpreter logInterpreter = new LogInterpreter();

        String log = logInterpreter.log("{0} write log {1} {2}", "weijianyu", "hello", "world");
        System.out.println(log);
        Assert.assertEquals("weijianyu write log hello world", log);
    }

}
