package sevenkey.open.utils.designpatterns.build.builder;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 生成器
 * Builder模式是为了创建一个复杂的对象，需要多个步骤完成创建，或者需要多个零件组装的场景，且创建过程中可以灵活调用不同的步骤或组件。
 *
 * @author weijianyu
 */
public class KeyBuilder {

    private ABuilder aBuilder = new ABuilder();
    private BBuilder bBuilder = new BBuilder();
    private CBuilder cBuilder = new CBuilder();

    public String build(List<String> keys) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String key : keys) {
            if (StringUtils.equals("A", key)) {
                stringBuilder.append(aBuilder.buildA());
            } else if (StringUtils.equals("B", key)) {
                stringBuilder.append(bBuilder.buildB());
            } else if (StringUtils.equals("C", key)) {
                stringBuilder.append(cBuilder.buildC());
            } else {
                throw new IllegalArgumentException("fail");
            }
        }

        return stringBuilder.toString();
    }
}
