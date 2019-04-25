package utils;

import base.TransactionTestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sevenkey.open.utils.service.ZebraService;

/**
 * @author weijianyu
 */
public class ZebraMasterTest extends TransactionTestBase {

    @Autowired
    private ZebraService zebraService;

    @Test
    public void testZebraMaster() {
        int key = zebraService.sum();
        Assert.assertEquals(key, 0);
    }
}
