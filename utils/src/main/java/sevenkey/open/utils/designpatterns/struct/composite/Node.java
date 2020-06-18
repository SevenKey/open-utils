package sevenkey.open.utils.designpatterns.struct.composite;

import java.util.List;

/**
 * Composite模式
 * Composite模式使得叶子对象和容器对象具有一致性，从而形成统一的树形结构，并用一致的方式去处理它们。
 *
 * @author weijianyu
 */
public interface Node {
    /**
     * 添加节点
     *
     * @param node 节点
     * @return Node
     */
    Node addNode(Node node);

    /**
     * 子节点
     *
     * @return List<Node>
     */
    List<Node> children();

    /**
     * 转换成 xml
     *
     * @return xml
     */
    String toXml();
}
