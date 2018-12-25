package sevenkey.open.utils.common.enums;

/**
 * 请求返回结果通用枚举
 *
 * @author weijianyu
 */
public enum ResponseEnum {
    /**
     * 请求成功
     */
    SUCCESS(1, "success"),
    /**
     * 请求失败
     */
    FAIL(0, "fail"),
    /**
     * 入参异常
     */
    PARAM_FAIL(1000, "参数异常");
    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }}
