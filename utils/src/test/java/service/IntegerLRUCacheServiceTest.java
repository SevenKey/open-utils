package service;

import base.TransactionTestBase;
import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.service.AbstractLRUCacheService;
import sevenkey.open.utils.service.IntegerLRUCacheService;

import javax.annotation.Resource;

public class IntegerLRUCacheServiceTest extends TransactionTestBase {

    @Resource
    private IntegerLRUCacheService integerLRUCacheService;

    @Test
    public void setLru() {
        AbstractLRUCacheService.Leader leader = null;

        integerLRUCacheService.setValue("first", 1);
        Assert.assertEquals(1, integerLRUCacheService.getValue("first").intValue());
        leader = integerLRUCacheService.getLeader();
        Assert.assertEquals(1,leader.getSize());
        Assert.assertEquals("first",leader.getHead().getData().getKey());
        Assert.assertEquals(1,leader.getHead().getData().getValue());
        Assert.assertEquals("first",leader.getTail().getData().getKey());
        Assert.assertEquals(1,leader.getTail().getData().getValue());

        integerLRUCacheService.setValue("second", 2);
        Assert.assertEquals(2, integerLRUCacheService.getValue("second").intValue());
        leader = integerLRUCacheService.getLeader();
        Assert.assertEquals(2,leader.getSize());
        Assert.assertEquals("second",leader.getHead().getData().getKey());
        Assert.assertEquals(2,leader.getHead().getData().getValue());
        Assert.assertEquals("first",leader.getTail().getData().getKey());
        Assert.assertEquals(1,leader.getTail().getData().getValue());

        Assert.assertEquals(1, integerLRUCacheService.getValue("first").intValue());
        leader = integerLRUCacheService.getLeader();
        Assert.assertEquals(2,leader.getSize());
        Assert.assertEquals("first",leader.getHead().getData().getKey());
        Assert.assertEquals(1,leader.getHead().getData().getValue());
        Assert.assertEquals("second",leader.getTail().getData().getKey());
        Assert.assertEquals(2,leader.getTail().getData().getValue());

        integerLRUCacheService.setValue("third", 3);
        Assert.assertEquals(3, integerLRUCacheService.getValue("third").intValue());
        leader = integerLRUCacheService.getLeader();
        Assert.assertEquals(3,leader.getSize());
        Assert.assertEquals("third",leader.getHead().getData().getKey());
        Assert.assertEquals(3,leader.getHead().getData().getValue());
        Assert.assertEquals("second",leader.getTail().getData().getKey());
        Assert.assertEquals(2,leader.getTail().getData().getValue());

        integerLRUCacheService.setValue("four", 4);
        Assert.assertEquals(4, integerLRUCacheService.getValue("four").intValue());
        leader = integerLRUCacheService.getLeader();
        Assert.assertEquals(3,leader.getSize());
        Assert.assertEquals("four",leader.getHead().getData().getKey());
        Assert.assertEquals(4,leader.getHead().getData().getValue());
        Assert.assertEquals("first",leader.getTail().getData().getKey());
        Assert.assertEquals(1,leader.getTail().getData().getValue());

        Assert.assertEquals(1, integerLRUCacheService.getValue("first").intValue());
        leader = integerLRUCacheService.getLeader();
        Assert.assertEquals(3,leader.getSize());
        Assert.assertEquals("first",leader.getHead().getData().getKey());
        Assert.assertEquals(1,leader.getHead().getData().getValue());
        Assert.assertEquals("third",leader.getTail().getData().getKey());
        Assert.assertEquals(3,leader.getTail().getData().getValue());
    }
}
