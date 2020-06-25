package sevenkey.open.utils.designpatterns.action.command.impl;

import org.apache.commons.lang3.StringUtils;

/**
 * 文本编辑器
 *
 * @author weijianyu
 */
public class TextEditor {

    private StringBuilder stringBuilder = new StringBuilder();

    public void add(String text) {
        stringBuilder.append(text);
    }

    public void delete() {
        if (StringUtils.isNotBlank(stringBuilder.toString())) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public String getState() {
        return stringBuilder.toString();
    }

    public void clear() {
        if (StringUtils.isNotBlank(stringBuilder.toString())) {
            stringBuilder.delete(0, stringBuilder.length());
        }
    }
}
