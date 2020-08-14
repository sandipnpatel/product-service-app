package com.avengers.hackathon.repository;

import com.avengers.hackathon.ProductServiceApplication;
import com.avengers.hackathon.model.CustomerProductMapping;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerProductMappingRepositoryTest {

    @Autowired
    private CustomerProductRepository customerProductRepository;

    @Test
    @DisplayName("Should able to fetch all CustomerProductMapping by customer Id and product Id.")
    public void testFindCustomerProductMappingsById() {
        List<CustomerProductMapping> customerProductMappingList = customerProductRepository.findCustomerProductMappingsById(1L, 1L);
        Assert.assertEquals(customerProductMappingList.size(), 1);
    }

    @Test
    @DisplayName("Should able to fetch all productIds by customer Id.")
    public void testFindProductIdsByCustomerId() {
        List<Long> productIds = customerProductRepository.getProductIds(1L);
        Assert.assertArrayEquals(new Long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L}, productIds.toArray());
    }
}
