package com.avengers.hackathon.repository.test;

import com.avengers.hackathon.ProductServiceApplication;
import com.avengers.hackathon.model.CustomerProductMapping;
import com.avengers.hackathon.repository.CustomerProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerProductRepositoryTest {

    @Autowired
    private CustomerProductRepository customerProductRepository;

    @Test
    public void testFindCustomerProductMappingsById() {
        List<CustomerProductMapping> customerProductRepositoryList = customerProductRepository.findCustomerProductMappingsById(1L, 1L);
        Assert.assertEquals(customerProductRepositoryList.size(), 1);
    }
}
