package com.ing.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.product.ProductServiceApplication;
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


import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
class CustomerControllerIntegrationTest {


    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("Get all Customer product.")
    public void testGetAllCustomerProducts() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        String jsonResponse = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:"+port+"/v1/customers/1/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn()
                .getResponse().getContentAsString();

        assertEquals(getExpectedCustomerProductsResult(), jsonResponse);

    }

    @Test
    @DisplayName("Expect Bad Request when customernot exits.")
    public void testGetAllCustomerProducts_whenCustomerNotExists() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:"+port+"/v1/customers/100/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(400));

    }

    private String getExpectedCustomerProductsResult() {
        return "[{\"id\":1,\"name\":\"Orange Savings Account\",\"group\":\"Savings\"},{\"id\":2,\"name\":\"Savings Deposit\",\"group\":\"Savings\"},{\"id\":3,\"name\":\"Bonus Interest Account\",\"group\":\"Savings\"},{\"id\":4,\"name\":\"Interest only\",\"group\":\"Mortgage\"}]";
    }


    @Test
    @DisplayName("Get Specific product of Customer.")
    public void testGetCustomerProduct() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        String jsonResponse = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:"+port+"/v1/customers/1/products/4")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn()
                .getResponse().getContentAsString();

        assertEquals(getExpectedProductResult(), jsonResponse);

    }

    private String getExpectedProductResult() {
        return "[{\"id\":4,\"name\":\"Interest only\",\"accountNumber\":\"4463453\",\"interestRate\":5,\"amount\":3000,\"maturityAmount\":500}]";
    }

    @Test
    @DisplayName("Expect Bad Request when customer or product not exits.")
    public void testGetCustomerProduct_whenCustomerOrProductNotExists() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:"+port+"/v1/customers/1/products/0")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
}