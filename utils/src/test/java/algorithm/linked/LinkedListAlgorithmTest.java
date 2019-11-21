package algorithm.linked;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.algorithm.linked.LinkedListAlgorithm;

public class LinkedListAlgorithmTest {

    private LinkedListAlgorithm linkedListAlgorithm = new LinkedListAlgorithm();

    @Test
    public void testMergeTwoLists() {
        LinkedListAlgorithm.Node l1 = linkedListAlgorithm.new Node();
        l1.setData(1);
        LinkedListAlgorithm.Node l1Second = linkedListAlgorithm.new Node();
        l1Second.setData(2);
        l1.setNext(l1Second);
        LinkedListAlgorithm.Node l1Third = linkedListAlgorithm.new Node();
        l1Third.setData(3);
        l1Second.setNext(l1Third);

        LinkedListAlgorithm.Node l2 = linkedListAlgorithm.new Node();
        l2.setData(4);
        LinkedListAlgorithm.Node l2Second = linkedListAlgorithm.new Node();
        l2Second.setData(5);
        l2.setNext(l2Second);

        LinkedListAlgorithm.Node mergeHead = linkedListAlgorithm.mergeTwoLists(l1, l2);
        Assert.assertNotNull(mergeHead);
        LinkedListAlgorithm.Node p = mergeHead;
        int value = 1;
        while (null != p) {
            Assert.assertEquals(value, p.getData());
            p = p.getNext();
            value++;
        }
    }

    @Test
    public void testReverse0() {
        LinkedListAlgorithm.Node reverse = null;
        // 空链表
        reverse = linkedListAlgorithm.reverse(null);
        Assert.assertNull(reverse);
    }

    @Test
    public void testReverse1() {
        LinkedListAlgorithm.Node reverse = null;

        LinkedListAlgorithm.Node head = linkedListAlgorithm.new Node();
        head.setData(1);
        // 一个节点
        reverse = linkedListAlgorithm.reverse(head);
        Assert.assertEquals(head, reverse);
    }

    @Test
    public void testReverse2() {
        LinkedListAlgorithm.Node reverse = null;

        LinkedListAlgorithm.Node head = linkedListAlgorithm.new Node();
        head.setData(1);
        LinkedListAlgorithm.Node second = linkedListAlgorithm.new Node();
        second.setData(2);
        head.setNext(second);
        // 两个节点
        reverse = linkedListAlgorithm.reverse(head);
        Assert.assertEquals(second, reverse);
        Assert.assertEquals(head, reverse.getNext());
    }

    @Test
    public void testReverse3() {
        LinkedListAlgorithm.Node reverse = null;

        LinkedListAlgorithm.Node head = linkedListAlgorithm.new Node();
        head.setData(1);
        LinkedListAlgorithm.Node second = linkedListAlgorithm.new Node();
        second.setData(2);
        head.setNext(second);
        LinkedListAlgorithm.Node third = linkedListAlgorithm.new Node();
        third.setData(3);
        second.setNext(third);
        // 三个节点
        reverse = linkedListAlgorithm.reverse(head);
        Assert.assertEquals(third, reverse);
        Assert.assertEquals(second, reverse.getNext());
        Assert.assertEquals(head, reverse.getNext().getNext());
    }

    @Test
    public void testReverse4() {
        LinkedListAlgorithm.Node reverse = null;

        LinkedListAlgorithm.Node head = linkedListAlgorithm.new Node();
        head.setData(1);
        LinkedListAlgorithm.Node second = linkedListAlgorithm.new Node();
        second.setData(2);
        head.setNext(second);
        LinkedListAlgorithm.Node third = linkedListAlgorithm.new Node();
        third.setData(3);
        second.setNext(third);
        LinkedListAlgorithm.Node four = linkedListAlgorithm.new Node();
        four.setData(4);
        third.setNext(four);
        // 四个节点
        reverse = linkedListAlgorithm.reverse(head);
        Assert.assertEquals(four, reverse);
        Assert.assertEquals(third, reverse.getNext());
        Assert.assertEquals(second, reverse.getNext().getNext());
        Assert.assertEquals(head, reverse.getNext().getNext().getNext());
    }

    @Test
    public void testCheckCircle() {
        Assert.assertFalse(linkedListAlgorithm.checkCircle(null));

        LinkedListAlgorithm.Node head = linkedListAlgorithm.new Node();
        head.setData(1);
        LinkedListAlgorithm.Node second = linkedListAlgorithm.new Node();
        second.setData(2);
        head.setNext(second);
        LinkedListAlgorithm.Node third = linkedListAlgorithm.new Node();
        third.setData(3);
        second.setNext(third);
        LinkedListAlgorithm.Node four = linkedListAlgorithm.new Node();
        four.setData(4);
        third.setNext(four);
        Assert.assertFalse(linkedListAlgorithm.checkCircle(head));

        four.setNext(second);
        Assert.assertTrue(linkedListAlgorithm.checkCircle(head));
    }

    @Test
    public void testDeleteLastKth() {
        Assert.assertNull(linkedListAlgorithm.deleteLastKth(null, 1));

        LinkedListAlgorithm.Node head = linkedListAlgorithm.new Node();
        head.setData(1);
        LinkedListAlgorithm.Node second = linkedListAlgorithm.new Node();
        second.setData(2);
        head.setNext(second);
        LinkedListAlgorithm.Node third = linkedListAlgorithm.new Node();
        third.setData(3);
        second.setNext(third);
        LinkedListAlgorithm.Node four = linkedListAlgorithm.new Node();
        four.setData(4);
        third.setNext(four);

        Assert.assertEquals(head, linkedListAlgorithm.deleteLastKth(head, 10));

        Assert.assertEquals(head, linkedListAlgorithm.deleteLastKth(head, 2));
        Assert.assertEquals(second, head.getNext());
        Assert.assertEquals(four, head.getNext().getNext());
    }

    @Test
    public void testFindMiddleNode() {
        // 空链表
        LinkedListAlgorithm.Node middleNode = null;
        middleNode = linkedListAlgorithm.findMiddleNode(null);
        Assert.assertNull(middleNode);

        LinkedListAlgorithm.Node head = linkedListAlgorithm.new Node();
        head.setData(1);
        // 一个节点
        middleNode = linkedListAlgorithm.findMiddleNode(head);
        Assert.assertEquals(head, middleNode);

        LinkedListAlgorithm.Node second = linkedListAlgorithm.new Node();
        second.setData(2);
        head.setNext(second);
        // 两个节点
        middleNode = linkedListAlgorithm.findMiddleNode(head);
        Assert.assertEquals(second, middleNode);

        LinkedListAlgorithm.Node third = linkedListAlgorithm.new Node();
        third.setData(3);
        second.setNext(third);
        // 三个节点
        middleNode = linkedListAlgorithm.findMiddleNode(head);
        Assert.assertEquals(second, middleNode);

        LinkedListAlgorithm.Node four = linkedListAlgorithm.new Node();
        four.setData(4);
        third.setNext(four);
        // 四个节点
        middleNode = linkedListAlgorithm.findMiddleNode(head);
        Assert.assertEquals(third, middleNode);
    }
}
