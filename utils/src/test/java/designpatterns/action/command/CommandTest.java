package designpatterns.action.command;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.designpatterns.action.command.Invoker;
import sevenkey.open.utils.designpatterns.action.command.impl.AddCommand;
import sevenkey.open.utils.designpatterns.action.command.impl.DeleteCommand;
import sevenkey.open.utils.designpatterns.action.command.impl.TextEditor;

/**
 * @author weijianyu
 */
public class CommandTest {

    @Test
    public void test() {
        TextEditor textEditor = new TextEditor();

        AddCommand addCommand1 = new AddCommand(textEditor, "a");
        AddCommand addCommand2 = new AddCommand(textEditor, "b");
        AddCommand addCommand3 = new AddCommand(textEditor, "c");

        DeleteCommand deleteCommand1 = new DeleteCommand(textEditor);

        Invoker invoker = new Invoker();
        invoker.setCommands(Lists.newArrayList(addCommand1, addCommand2, addCommand3, deleteCommand1));


        invoker.invoke();
        Assert.assertEquals("ab", textEditor.getState());
        invoker.redo();
        Assert.assertEquals("abab", textEditor.getState());

        textEditor.clear();
        Assert.assertEquals("", textEditor.getState());
        invoker.invoke();
        Assert.assertEquals("ab", textEditor.getState());
        invoker.undo();
        Assert.assertEquals("", textEditor.getState());
    }

}
