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

    @Test
    public void test() throws Exception {
        int count = 1;
        int size = 2000;
        int key = 30171678;
        int sum = 0;

        FileWriter writer = new FileWriter(this.getClass().getResource("").getPath() + "sql.text");
        while (count <= key) {
            sum += 1;
            writer.write("UPDATE outbound_bill SET scheduled_delivery_date = DATE_FORMAT(DATE_ADD(order_time, INTERVAL 1 DAY), '%Y-%m-%d') WHERE id BETWEEN " + count + " AND " + (count + size) + ";\n");
            if (sum % 1000 == 0) {
                writer.write("\n");
                writer.write("\n");
            }
            count += size;
        }
        writer.close();
    }
}
