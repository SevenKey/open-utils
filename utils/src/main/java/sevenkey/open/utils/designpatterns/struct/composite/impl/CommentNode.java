package sevenkey.open.utils.designpatterns.struct.composite.impl;

import sevenkey.open.utils.designpatterns.struct.composite.Node;

import java.util.Collections;
import java.util.List;

/**
 * @author weijianyu
 */
public class CommentNode implements Node {

    private String comment;

    public CommentNode(String comment) {
        this.comment = comment;
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
        return "<!--" + comment + "-->";
    }
}
