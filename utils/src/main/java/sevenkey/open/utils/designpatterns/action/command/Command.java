package sevenkey.open.utils.designpatterns.action.command;

/**
 * command 模式
 * 命令模式的设计思想是把命令的创建和执行分离，使得调用者无需关心具体的执行过程。
 * 通过封装Command对象，命令模式可以保存已执行的命令，从而支持撤销、重做等操作。
 *
 * @author weijianyu
 */
public interface Command {

    /**
     * 执行
     */
    void execute();

    /**
     * 重试
     */
    void redo();

    /**
     * 撤回
     */
    void undo();
}
