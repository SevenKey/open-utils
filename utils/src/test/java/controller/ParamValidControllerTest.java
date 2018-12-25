package controller;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sevenkey.open.utils.ApplicationLoader;
import sevenkey.open.utils.common.enums.ResponseEnum;
import sevenkey.open.utils.model.body.ParamTestBody;
import sevenkey.open.utils.model.vo.ResponseVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationLoader.class)
@WebAppConfiguration
public class ParamValidControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testParamValid1() throws Exception {
        ParamTestBody body = new ParamTestBody();
        body.setId(1);
        body.setMessage("id:1");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/param/valid").content(JSON.toJSONString(body))
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        ResponseVO<String> response = new ResponseVO<>();
        Assert.assertEquals(response.success(ResponseEnum.SUCCESS, ResponseEnum.SUCCESS.getMessage()), JSON.parseObject(result.getResponse().getContentAsString(), ResponseVO.class));
    }

    @Test
    public void testParamValid2() throws Exception {
        ParamTestBody body = new ParamTestBody();
        body.setId(-1);
        body.setMessage("id:-1");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/param/valid").content(JSON.toJSONString(body))
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        ResponseVO<String> response = new ResponseVO<>();
        Assert.assertEquals(response.fail(ResponseEnum.PARAM_FAIL, "id must gt 0"), JSON.parseObject(result.getResponse().getContentAsString(), ResponseVO.class));
    }

    @Test
    public void testParamValid3() throws Exception {
        ParamTestBody body = new ParamTestBody();
        body.setId(1);
        body.setMessage("");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/param/valid").content(JSON.toJSONString(body))
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        ResponseVO<String> response = new ResponseVO<>();
        Assert.assertEquals(response.fail(ResponseEnum.PARAM_FAIL, "message must not blank"), JSON.parseObject(result.getResponse().getContentAsString(), ResponseVO.class));
    }

    @Test
    public void testParamValid4() throws Exception {
        ParamTestBody body = new ParamTestBody();
        body.setId(-1);
        body.setMessage("");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/param/valid").content(JSON.toJSONString(body))
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        ResponseVO<String> response = new ResponseVO<>();
        Assert.assertEquals(response.fail(ResponseEnum.PARAM_FAIL, "id must gt 0 message must not blank "), JSON.parseObject(result.getResponse().getContentAsString(), ResponseVO.class));
    }
}
