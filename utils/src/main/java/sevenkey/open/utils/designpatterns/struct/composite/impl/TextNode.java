package sevenkey.open.utils.designpatterns.struct.composite.impl;

import sevenkey.open.utils.designpatterns.struct.composite.Node;

import java.util.Collections;
import java.util.List;

/**
 * @author weijianyu
 */
public class TextNode implements Node {

    private String name;

    public TextNode(String name) {
        this.name = name;
    }

    @Override
    public Node addNode(Node node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Node> children() {
        return Collections.emptyList();
    }

    @Override
    public String toXml() {
        return name;
    }
}
