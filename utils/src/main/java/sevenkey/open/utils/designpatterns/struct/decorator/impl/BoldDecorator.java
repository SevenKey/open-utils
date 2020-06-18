package sevenkey.open.utils.designpatterns.struct.decorator.impl;

import sevenkey.open.utils.designpatterns.struct.decorator.NodeDecorator;
import sevenkey.open.utils.designpatterns.struct.decorator.TextNode;

/**
 * @author weijianyu
 */
public class BoldDecorator extends NodeDecorator {

    public BoldDecorator(TextNode textNode) {
        super(textNode);
    }

    @Override
    public String getText() {
        return "<b>" + textNode.getText() + "</b>" + "\n";
    }
}
