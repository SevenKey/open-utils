package sevenkey.open.utils.designpatterns.action.command.impl;

import org.apache.commons.lang3.StringUtils;
import sevenkey.open.utils.designpatterns.action.command.Command;

/**
 * 添加命令
 *
 * @author weijianyu
 */
public class AddCommand implements Command {

    private TextEditor textEditor;

    private String text;

    public AddCommand(TextEditor textEditor, String text) {
        this.textEditor = textEditor;
        this.text = text;
    }

    @Override
    public void execute() {
        textEditor.add(text);
    }

    @Override
    public void redo() {
        textEditor.add(text);
    }

    @Override
    public void undo() {
        if (StringUtils.isBlank(text)) {
            return;
        }

        for (char s : text.toCharArray()) {
            textEditor.delete();
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
