package com.springmvc.test;

import com.springmvc.controller.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by peng.zhang
 * Description:发起了对“/”的GET请求，并断言结果视图的名称为home。
 * 它首先传递一个HomeController实例到MockMvcBuilders.standaloneSetup()并调用build()来构建MockMvc实例。
 * 然后它使用MockMvc实例来执行针对“/”的GET请求并设置期望得到的视图名称。
 * Time: 2019/8/28-17:05.
 */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

}
