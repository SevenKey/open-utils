package sevenkey.open.utils.designpatterns.build.prototype;

/**
 * @author weijianyu
 */
public class InnerObject {

    /**
     * 数字
     */
    private Double number;
    /**
     * 字符串
     */
    private String string;

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    /**
     * 原型 copy
     *
     * @return InnerObject
     */
    public InnerObject copy() {
        InnerObject innerObject = new InnerObject();
        innerObject.setNumber(this.number);
        innerObject.setString(this.string);

        return innerObject;
    }
}
