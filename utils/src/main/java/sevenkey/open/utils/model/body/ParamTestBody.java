package sevenkey.open.utils.model.body;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 入参校验测试body
 *
 * @author weijianyu
 */
@Data
public class ParamTestBody {

    /**
     * id不为空 并且id>0
     */
    @NotNull(message = "id must not null")
    @Min(value = 0, message = "id must gt 0")
    private Integer id;

    /**
     * message不为blank
     */
    @NotBlank(message = "message must not blank")
    private String message;

    /**
     * 参数没有任何校验
     */
    private String remark;
}
