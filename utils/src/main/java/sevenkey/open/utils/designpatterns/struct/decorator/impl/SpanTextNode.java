package sevenkey.open.utils.designpatterns.struct.decorator.impl;

import sevenkey.open.utils.designpatterns.struct.decorator.TextNode;

/**
 * @author weijianyu
 */
public class SpanTextNode implements TextNode {

    private String text;

    public SpanTextNode(String text) {
        this.text = text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return "<span>" + text + "</span>";
    }
}
