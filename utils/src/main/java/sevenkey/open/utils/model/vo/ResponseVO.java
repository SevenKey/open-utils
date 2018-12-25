package sevenkey.open.utils.model.vo;

import lombok.Data;
import sevenkey.open.utils.common.enums.ResponseEnum;

/**
 * 通用请求返回体
 *
 * @author weijianyu
 */
@Data
public class ResponseVO<T> {
    private ResponseVO.HttpStatus status;
    private String message;
    private Integer code;
    private T data;

    /**
     * 构建成功请求
     *
     * @param responseEnum 返回信息枚举
     * @param data         数据
     * @return response
     */
    public ResponseVO<T> success(ResponseEnum responseEnum, T data) {
        this.status = HttpStatus.SUCCESS;
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.data = data;
        return this;
    }

    /**
     * 构建失败请求
     *
     * @param responseEnum 返回信息枚举
     * @return response
     */
    public ResponseVO<T> fail(ResponseEnum responseEnum) {
        this.status = HttpStatus.FAIL;
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        return this;
    }

    /**
     * 构建失败请求
     *
     * @param responseEnum 返回信息枚举
     * @param errorMessage 错误信息
     * @return response
     */
    public ResponseVO<T> fail(ResponseEnum responseEnum, String errorMessage) {
        this.status = HttpStatus.FAIL;
        this.code = responseEnum.getCode();
        this.message = errorMessage;
        return this;
    }

    public enum HttpStatus {
        /**
         * 请求失败
         */
        FAIL(0),
        /**
         * 请求成功
         */
        SUCCESS(1);
        private int status;

        HttpStatus(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
    }
}
