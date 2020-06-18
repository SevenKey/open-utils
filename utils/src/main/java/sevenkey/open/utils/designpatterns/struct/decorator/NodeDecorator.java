package sevenkey.open.utils.designpatterns.struct.decorator;

/**
 * Decorator模式
 * 使用Decorator模式，可以独立增加核心功能，也可以独立增加附加功能，二者互不影响；
 * 可以在运行期动态地给核心功能增加任意个附加功能。
 *
 * @author weijianyu
 */
public abstract class NodeDecorator implements TextNode {

    protected final TextNode textNode;

    public NodeDecorator(TextNode textNode) {
        this.textNode = textNode;
    }

    @Override
    public void setText(String text) {
        textNode.setText(text);
    }
}
