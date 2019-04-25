package controller;

import base.TransactionTestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sevenkey.open.utils.common.enums.ResponseEnum;

/**
 * @author weijianyu
 */
public class AliveControllerMyTest extends TransactionTestBase {
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
