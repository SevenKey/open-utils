package sevenkey.open.utils.designpatterns.struct.decorator;

/**
 * @author weijianyu
 */
public interface TextNode {

    /**
     * 设置 text
     *
     * @param text text
     */
    void setText(String text);

    /**
     * 获取 text
     *
     * @return String
     */
    String getText();
}
