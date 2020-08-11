package com.avengers.hackathon

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceApplicationSpec extends Specification {

    @Autowired
    private WebApplicationContext webApplicationContext

    @LocalServerPort
    private int port

    @Unroll
    def "Black Box test Scenarios"() {
        given:
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build()
        ObjectMapper objectMapper = new ObjectMapper()

        when:
        String responseBody = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:" + port + requestUri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(statusCode))
                .andReturn()
                .getResponse().getContentAsString()

        then:
        JsonNode expected = objectMapper.readTree(new FileReader(new ClassPathResource("integration-tests/scenarios/$responseFileName").getFile()))
        JsonNode actual = objectMapper.readTree(responseBody)
        Assert.assertEquals(actual, expected)


        where:
        scenario                               | requestUri                  | statusCode | responseFileName
        "Valid Customer 1 all product request" | "/v1/customer/1/products"   | 200        | "customer_1_products.json"
        "Valid Customer 2 all product request" | "/v1/customer/2/products"   | 200        | "customer_2_products.json"
        "Valid Customer 3 all product request" | "/v1/customer/3/products"   | 200        | "customer_3_products.json"
        "Valid Customer 4 all product request" | "/v1/customer/4/products"   | 200        | "customer_4_products.json"
        "Valid Customer 1 product 1 request"   | "/v1/customer/1/product/1"  | 200        | "customer_1_product_1.json"
        "Valid Customer 1 product 2 request"   | "/v1/customer/1/product/2"  | 200        | "customer_1_product_2.json"
        "Valid Customer 1 product 3 request"   | "/v1/customer/1/product/3"  | 200        | "customer_1_product_3.json"
        "Valid Customer 1 product 4 request"   | "/v1/customer/1/product/4"  | 200        | "customer_1_product_4.json"
        "Valid Customer 1 product 5 request"   | "/v1/customer/1/product/5"  | 200        | "customer_1_product_5.json"
        "Valid Customer 1 product 6 request"   | "/v1/customer/1/product/6"  | 200        | "customer_1_product_6.json"
        "Valid Customer 1 product 7 request"   | "/v1/customer/1/product/7"  | 200        | "customer_1_product_7.json"
        "Valid Customer 1 product 8 request"   | "/v1/customer/1/product/8"  | 200        | "customer_1_product_8.json"
        "Valid Customer 1 product 9 request"   | "/v1/customer/1/product/9"  | 200        | "customer_1_product_9.json"
        "Valid Customer 1 product 10 request"  | "/v1/customer/1/product/10" | 200        | "customer_1_product_10.json"
        "Valid Customer 1 product 11 request"  | "/v1/customer/1/product/11" | 200        | "customer_1_product_11.json"
        "Valid Customer 1 product 12 request"  | "/v1/customer/1/product/12" | 200        | "customer_1_product_12.json"
        "Valid Customer 1 product 13 request"  | "/v1/customer/1/product/13" | 200        | "customer_1_product_13.json"
        "Valid Customer 1 product 14 request"  | "/v1/customer/1/product/14" | 200        | "customer_1_product_14.json"
        "Valid Customer 2 product 1 request"   | "/v1/customer/2/product/1"  | 200        | "customer_2_product_1.json"
        "Valid Customer 2 product 4 request"   | "/v1/customer/2/product/4"  | 200        | "customer_2_product_4.json"
        "Valid Customer 2 product 6 request"   | "/v1/customer/2/product/6"  | 200        | "customer_2_product_6.json"
        "Valid Customer 3 product 7 request"   | "/v1/customer/3/product/7"  | 200        | "customer_3_product_7.json"
        "Valid Customer 3 product 9 request"   | "/v1/customer/3/product/9"  | 200        | "customer_3_product_9.json"
        "Valid Customer 4 product 12 request"  | "/v1/customer/4/product/12" | 200        | "customer_4_product_12.json"

    }

}
