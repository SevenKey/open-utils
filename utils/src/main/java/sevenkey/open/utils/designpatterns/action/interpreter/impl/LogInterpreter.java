package sevenkey.open.utils.designpatterns.action.interpreter.impl;

import org.apache.commons.lang3.StringUtils;
import sevenkey.open.utils.designpatterns.action.interpreter.Interpreter;

import java.text.MessageFormat;

/**
 * @author weijianyu
 */
public class LogInterpreter implements Interpreter {

    @Override
    public String log(String string, Object... objs) {
        if(StringUtils.isBlank(string)){
            return StringUtils.EMPTY;
        }

        return MessageFormat.format(string,objs);
    }
}
