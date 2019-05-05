package utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.exception.ParamException;
import sevenkey.open.utils.model.body.ParamTestBody;
import sevenkey.open.utils.utils.ParamValidUtils;

import java.io.FileWriter;


/**
 * 通用入参校验 测试类
 *
 * @author weijianyu
 */
public class ParamValidUtilsMyTest {

    @Test
    public void testCommonParamValid1() throws ParamException {
        // 正常校验
        ParamTestBody body = new ParamTestBody();
        body.setId(1);
        body.setMessage("我是id:1");
        ParamValidUtils.commonParamValid(body);
    }

    @Test(expected = ParamException.class)
    public void testCommonParamValid2() throws ParamException {
        // id失败校验 其余正常
        ParamTestBody body = new ParamTestBody();
        body.setId(-1);
        body.setMessage("我是id:1");
        ParamValidUtils.commonParamValid(body);
        Assert.fail();
    }

    @Test(expected = ParamException.class)
    public void testCommonParamValid3() throws ParamException {
        // message 失败校验 其余正常
        ParamTestBody body = new ParamTestBody();
        body.setId(1);
        body.setMessage(StringUtils.EMPTY);
        ParamValidUtils.commonParamValid(body);

        // 多重失败校验
        body.setId(-1);
        body.setMessage(StringUtils.EMPTY);
        ParamValidUtils.commonParamValid(body);
    }

    @Test(expected = ParamException.class)
    public void testCommonParamValid4() throws ParamException {
        // 多重失败校验
        ParamTestBody body = new ParamTestBody();
        body.setId(-1);
        body.setMessage(StringUtils.EMPTY);
        ParamValidUtils.commonParamValid(body);
    }
}
