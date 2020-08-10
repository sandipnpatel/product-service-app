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
        scenario        | requestUri                 | statusCode | responseFileName           | ignoredEntries
        "Valid Customer 1 all product request" | "/v1/customers/1/products" | 200        | "customer_1_products.json" | ""
        "Valid Customer 2 all product request" | "/v1/customers/2/products" | 200        | "customer_2_products.json" | ""
        "Valid Customer 3 all product request" | "/v1/customers/3/products" | 200        | "customer_3_products.json" | ""
        "Valid Customer 4 all product request" | "/v1/customers/4/products" | 200        | "customer_4_products.json" | ""

    }

}
