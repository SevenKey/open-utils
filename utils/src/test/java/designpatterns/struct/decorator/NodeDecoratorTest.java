package designpatterns.struct.decorator;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.designpatterns.struct.decorator.impl.BoldDecorator;
import sevenkey.open.utils.designpatterns.struct.decorator.impl.SpanTextNode;

/**
 * @author weijianyu
 */
public class NodeDecoratorTest {

    @Test
    public void test(){
        SpanTextNode span = new SpanTextNode("我是一个span");
        BoldDecorator decorator = new BoldDecorator(span);
        Assert.assertNotNull(decorator.getText());
        System.out.println(decorator.getText());
    }
}
