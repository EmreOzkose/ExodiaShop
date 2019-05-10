package com.exodiashop.shop;

import com.exodiashop.shop.Controller.DashboardController;
import com.exodiashop.shop.Model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DashboardController.class)
@ContextConfiguration(classes = {Customer.class, DashboardController.class})
public class DashboardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHappy() throws Exception{
        MvcResult result = this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(), "Hello World");

    }
}