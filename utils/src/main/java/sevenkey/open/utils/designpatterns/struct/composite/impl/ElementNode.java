package sevenkey.open.utils.designpatterns.struct.composite.impl;

import com.google.common.collect.Lists;
import sevenkey.open.utils.designpatterns.struct.composite.Node;

import java.util.List;

/**
 * @author weijianyu
 */
public class ElementNode implements Node {

    private List<Node> list = Lists.newArrayList();

    private String name;

    public ElementNode(String name) {
        this.name = name;
    }

    @Override
    public Node addNode(Node node) {
        list.add(node);
        return this;
    }

    @Override
    public List<Node> children() {
        return list;
    }

    @Override
    public String toXml() {
        String start = "<" + name + ">\n";
        String end = "<" + name + "/>\n";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(start);
        for (Node node : list) {
            stringBuilder.append(node.toXml()).append("\n");
        }
        stringBuilder.append(end);

        return stringBuilder.toString();
    }
}
