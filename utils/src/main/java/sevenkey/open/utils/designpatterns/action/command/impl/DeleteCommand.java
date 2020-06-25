package sevenkey.open.utils.designpatterns.action.command.impl;

import sevenkey.open.utils.designpatterns.action.command.Command;

/**
 * 删除命令
 *
 * @author weijianyu
 */
public class DeleteCommand implements Command {

    private TextEditor textEditor;

    public DeleteCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void excute() {

    }

    @Override
    public void execute() {
        textEditor.delete();
    }

    @Override
    public void redo() {
        textEditor.delete();
    }

    @Override
    public void undo() {
    }
}
