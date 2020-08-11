package com.avengers.hackathon.repository;

import com.avengers.hackathon.ProductServiceApplication;
import com.avengers.hackathon.bean.Product;
import com.avengers.hackathon.model.Customer;
import com.avengers.hackathon.model.ProductEntity;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Should be able to fetch Product from repository.")
    public void testFindProductById() {
        Optional<ProductEntity> product = productRepository.findById(1L);

        Assert.assertEquals(ProductEntity.builder().id(1L).name("p_orange_savings").productGroup("pg_savings").interestRate(BigDecimal.valueOf(3.5)).build(), product.get());
    }
}
