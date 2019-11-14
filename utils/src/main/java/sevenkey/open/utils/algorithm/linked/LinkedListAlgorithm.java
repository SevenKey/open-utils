package sevenkey.open.utils.algorithm.linked;

import lombok.Data;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * @author weijianyu
 */
public class LinkedListAlgorithm {

    @Data
    public class Node {
        private int data;
        private Node next;
    }

    /**
     * 链表反转
     *
     * @param head 头结点
     * @return 反转链表头
     */
    public Node reverse(Node head) {
        Node r = null;

        Node p = head;
        while (null != p) {
            Node q = p.getNext();
            p.setNext(r);
            r = p;
            p = q;
        }

        return r;
    }

    /**
     * 链表是否有环
     *
     * @param head 头结点
     * @return true/false
     */
    public boolean checkCircle(Node head) {
        Node p = head;
        Node q = head;
        while (null != q && null != q.getNext()) {
            p = p.getNext();
            q = q.getNext().getNext();

            if (p == q) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除尾递 k 个节点
     *
     * @param head 头节点
     * @param k    k
     */
    public Node deleteLastKth(Node head, int k) {
        Node fast = head;
        int i = 1;
        while (null != fast && i < k) {
            fast = fast.getNext();
            i++;
        }
        if (null == fast) {
            return head;
        }

        Node prev = null;
        Node slow = head;
        while (null != fast.getNext()) {
            fast = fast.getNext();
            prev = slow;
            slow = slow.getNext();
        }

        if (null == prev) {
            return null;
        } else {
            prev.setNext(slow.getNext());
            slow.setNext(null);
        }
        return head;
    }

    /**
     * 寻找中心节点
     *
     * @param head 头结点
     */
    public Node findMiddleNode(Node head) {
        Node p = head;
        Node q = head;
        while (null != q && null != q.getNext()) {
            p = p.getNext();
            q = q.getNext().getNext();
        }

        return p;
    }
}
