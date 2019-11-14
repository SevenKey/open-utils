package sevenkey.open.utils.service;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * LRU 缓存淘汰服务
 *
 * @author weijianyu
 */
@Service
public abstract class AbstractLRUCacheService<T> {

    private static final int DEFAULT_VALUES = 3;

    private Leader leader;

    /**
     * 节点
     */
    @Data
    public class Node {
        private Node prev;
        private Entry data;
        private Node next;
    }

    /**
     * key-value
     */
    @Data
    public class Entry {
        private String key;
        private T value;
    }

    /**
     * 头节点
     * 记录一些基础信息 减少操作复杂度
     */
    @Data
    public class Leader {
        private Node head;
        private Node tail;
        private int size;
    }

    public AbstractLRUCacheService() {
        init();
    }

    private void init() {
        leader = new Leader();
        leader.setHead(null);
        leader.setTail(null);
        leader.setSize(0);
    }

    /**
     * 通过 key 获取 缓存 value
     *
     * @param key key
     * @return value
     */
    public T getValue(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        // 查询
        Node node = findValue(key);
        if (null != node) {
            lru(node);
            return node.getData().getValue();
        }
        return null;
    }

    /**
     * 设置缓存 value
     *
     * @param key   key
     * @param value value
     */
    public void setValue(String key, T value) {
        if (StringUtils.isBlank(key)) {
            return;
        }
        // 查询
        Node node = findValue(key);
        if (null != node) {
            node.getData().setValue(value);
            lru(node);
        } else {
            while (leader.getSize() + 1 > DEFAULT_VALUES) {
                remove(leader.getTail());
            }
            insertHead(key, value);
        }
    }

    /**
     * lru
     *
     * @param node node
     */
    private void lru(Node node) {
        if(leader.getHead() == node){
            return ;
        }
        // 删除
        remove(node);
        // 头插
        insertHead(node);
    }

    /**
     * 查询 lru
     *
     * @param key key
     * @return 节点
     */
    private Node findValue(String key) {
        Node p = leader.head;
        while (null != p) {
            if (StringUtils.equals(p.getData().getKey(), key)) {
                return p;
            }
            p = p.getNext();
        }
        return null;
    }

    /**
     * 删除
     *
     * @param node node
     */
    private void remove(Node node) {
        // 待删除是尾节点
        if (leader.getTail() == node) {
            node.getPrev().setNext(null);
            leader.setTail(node.getPrev());
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }

        node.setNext(null);
        node.setPrev(null);
        leader.size --;
    }


    /**
     * 头插
     *
     * @param key   key
     * @param value value
     */
    private void insertHead(String key, T value) {
        Entry entry = new Entry();
        entry.setKey(key);
        entry.setValue(value);

        Node node = new Node();
        node.setData(entry);
        node.setPrev(null);
        node.setNext(null);

        insertHead(node);
    }

    /**
     * 头插
     *
     * @param node node
     */
    private void insertHead(Node node) {
        if (null == leader.getHead()) {
            leader.setHead(node);
            leader.setTail(node);
        } else {
            Node target = leader.head;
            node.setNext(target);
            target.setPrev(node);

            leader.head = node;
        }
        leader.size++;
    }

    public Leader getLeader(){
        return leader;
    }
}
