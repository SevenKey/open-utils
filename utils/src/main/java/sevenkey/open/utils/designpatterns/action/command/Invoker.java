package sevenkey.open.utils.designpatterns.action.command;

import java.util.List;

/**
 * 封装
 *
 * @author weijianyu
 */
public class Invoker {

    /**
     * 命令列表
     */
    private List<Command> commands;

    /**
     * 执行
     */
    public void invoke() {
        commands.forEach(command -> command.execute());
    }

    /**
     * redo
     */
    public void redo() {
        commands.forEach(command -> command.redo());
    }

    /**
     * undo
     */
    public void undo() {
        commands.forEach(command -> command.undo());
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}
