package controller;

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

/**
 * @author weijianyu
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationLoader.class)
@WebAppConfiguration
public class AliveControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testAlive() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/alive").
                contentType(MediaType.APPLICATION_JSON)).andReturn();
        Assert.assertEquals(ResponseEnum.SUCCESS.getMessage(), result.getResponse().getContentAsString());
    }
}
