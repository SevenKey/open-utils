package designpatterns.build.builder;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.designpatterns.build.builder.KeyBuilder;

import java.util.List;

/**
 * @author weijianyu
 */
public class KeyBuilderTest {

    private KeyBuilder keyBuilder = new KeyBuilder();

    @Test
    public void test() {
        List<String> keys = Lists.newArrayList("A", "B", "C");
        String result = keyBuilder.build(keys);

        Assert.assertEquals("hello build A hello build B hello build C ", result);
    }
}
