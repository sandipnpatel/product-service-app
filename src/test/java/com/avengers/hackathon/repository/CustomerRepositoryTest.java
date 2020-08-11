package com.avengers.hackathon.repository;

import com.avengers.hackathon.ProductServiceApplication;
import com.avengers.hackathon.model.Customer;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Should be able to fetch Customer from repository.")
    public void testFindCustomerById() {
        Optional<Customer> customer = customerRepository.findById(1L);

        Assert.assertEquals(Customer.builder().id(1L).firstName("Sandip").lastName("Patel").build(), customer.get());
    }
}
