package sevenkey.open.utils.designpatterns.action.interpreter;

/**
 * Interpreter 解释器
 * 解释器模式通过抽象语法树实现对用户输入的解释执行。
 * 解释器模式的实现通常非常复杂，且一般只能解决一类特定问题。
 *
 * @author weijianyu
 */
public interface Interpreter {
    String log(String string, Object... objs);
}
