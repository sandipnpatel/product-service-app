package com.avengers.hackathon.controller;

import com.avengers.hackathon.ProductServiceApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
class CustomerControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("Get all Customer product.")
    public void testGetAllCustomerProducts() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:" + port + "/v1/customer/1/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    @DisplayName("Expect Bad Request when customer not exits.")
    public void testGetAllCustomerProducts_whenCustomerNotExists() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:" + port + "/v1/customer/100/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @DisplayName("Expect Bad Request when customer id is not numeric.")
    public void testGetAllCustomerProducts_whenCustomerIdIsNotNumeric() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:" + port + "/v1/customer/xyz/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @DisplayName("Get Specific product of Customer.")
    public void testGetCustomerProduct() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:" + port + "/v1/customer/1/product/4")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    @DisplayName("Expect Bad Request when customer or product not exits.")
    public void testGetCustomerProduct_whenCustomerOrProductNotExists() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:" + port + "/v1/customer/1/product/0")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    @DisplayName("Expect Bad Request when product id is not numeric.")
    public void testGetCustomerProduct_whenProductIdIsNotNumeric() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:" + port + "/v1/customer/1/product/0")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
}