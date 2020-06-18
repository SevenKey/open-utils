package designpatterns.build.prototype;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.designpatterns.build.prototype.InnerObject;
import sevenkey.open.utils.designpatterns.build.prototype.Original;

/**
 * @author weijianyu
 */
public class OriginalTest {

    @Test
    public void test() {
        Integer i = 521;
        Double j = 5.21;
        String a = "a";
        String b = "b";
        InnerObject innerObject = new InnerObject();
        innerObject.setNumber(j);
        innerObject.setString(b);


        Original original = new Original();
        original.setNumber(i);
        original.setString(a);
        original.setInnerObject(innerObject);

        Original copyObject = original.copy();
        Assert.assertEquals(original.getString(), copyObject.getString());
        Assert.assertEquals(original.getNumber(), copyObject.getNumber());
        Assert.assertEquals(original.getInnerObject().getNumber(), copyObject.getInnerObject().getNumber());
        Assert.assertEquals(original.getInnerObject().getString(), copyObject.getInnerObject().getString());

        // 原型模式是深度 copy
        copyObject.setString("m");
        copyObject.setNumber(10);
        copyObject.getInnerObject().setNumber(10.00);
        copyObject.getInnerObject().setString("n");
        Assert.assertNotEquals(original.getString(), copyObject.getString());
        Assert.assertNotEquals(original.getNumber(), copyObject.getNumber());
        Assert.assertNotEquals(original.getInnerObject().getNumber(), copyObject.getInnerObject().getNumber());
        Assert.assertNotEquals(original.getInnerObject().getString(), copyObject.getInnerObject().getString());
    }
}
