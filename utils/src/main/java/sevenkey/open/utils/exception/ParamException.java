package sevenkey.open.utils.exception;

/**
 * 自定义非运行时参数异常
 *
 * @author weijianyu
 */
public class ParamException extends Exception {

    private String errorMessage;

    public ParamException(String message) {
        super(message);
        errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
