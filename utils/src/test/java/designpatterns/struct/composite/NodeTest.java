package designpatterns.struct.composite;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.designpatterns.struct.composite.impl.CommentNode;
import sevenkey.open.utils.designpatterns.struct.composite.impl.ElementNode;
import sevenkey.open.utils.designpatterns.struct.composite.impl.TextNode;

/**
 * @author weijianyu
 */
public class NodeTest {

    @Test
    public void test() {
        ElementNode root = new ElementNode("school");
        root.addNode(new ElementNode("classA").addNode(new TextNode("Tom")).addNode(new TextNode("Jom"))
        );

        root.addNode(new ElementNode("classB").addNode(new TextNode("Any")).addNode(new TextNode("Jny")).addNode(new CommentNode("我是一个注释")));

        Assert.assertNotNull(root.toXml());
        System.out.println(root.toXml());
    }
}
