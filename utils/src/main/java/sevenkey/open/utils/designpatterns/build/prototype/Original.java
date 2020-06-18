package sevenkey.open.utils.designpatterns.build.prototype;

/**
 * 原型模式是根据一个现有对象实例复制出一个新的实例，复制出的类型和属性与原实例相同。
 *
 * @author weijianyu
 */
public class Original {

    /**
     * 数字
     */
    private Integer number;
    /**
     * 字符串
     */
    private String string;
    /**
     * 嵌套类
     */
    private InnerObject innerObject;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public InnerObject getInnerObject() {
        return innerObject;
    }

    public void setInnerObject(InnerObject innerObject) {
        this.innerObject = innerObject;
    }

    /**
     * 原型模式 copy
     *
     * @return Original
     */
    public Original copy() {
        Original original = new Original();
        original.setNumber(this.number);
        original.setString(this.string);
        original.setInnerObject(this.innerObject.copy());

        return original;
    }
}
