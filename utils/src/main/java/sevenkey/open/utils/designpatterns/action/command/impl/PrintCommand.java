package sevenkey.open.utils.designpatterns.action.command.impl;

import sevenkey.open.utils.designpatterns.action.command.Command;

/**
 * 展示命令
 *
 * @author weijianyu
 */
public class PrintCommand implements Command {

    private TextEditor textEditor;

    private String text;

    public PrintCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }


    @Override
    public void execute() {
        text = textEditor.getState();
    }

    @Override
    public void redo() {
        text = textEditor.getState();
    }

    @Override
    public void undo() {

    }

    public String getText() {
        return text;
    }
}
