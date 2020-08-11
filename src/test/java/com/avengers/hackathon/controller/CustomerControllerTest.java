package com.avengers.hackathon.controller;

import com.avengers.hackathon.bean.CustomerProduct;
import com.avengers.hackathon.bean.Product;
import com.avengers.hackathon.service.ProductService;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private ProductService productService;

    @Test
    @DisplayName("Should return Json from service when request is valid.")
    public void getAllProducts_whenRequestIsValid() {
        List<Product> products = Lists.newArrayList(Product.builder().build());
        Mockito.when(productService.getCustomerProducts(Mockito.eq(1L))).thenReturn(products);

        ResponseEntity<List<Product>> responseEntity = customerController.getAllProducts(1L);

        Assert.assertEquals(responseEntity.getStatusCodeValue(), 200);
        Assert.assertEquals(products, responseEntity.getBody());
    }

    @Test
    @DisplayName("Should return 400 when products are not available.")
    public void getAllProducts_whenProductsNotAvailable() {
        Mockito.when(productService.getCustomerProducts(Mockito.eq(1L))).thenReturn(new ArrayList<>());

        ResponseEntity<List<Product>> responseEntity = customerController.getAllProducts(1L);

        Assert.assertEquals(responseEntity.getStatusCodeValue(), 400);
    }

    @Test
    @DisplayName("Should return Json from service when request is valid.")
    public void getCustomerProducts_whenRequestIsValid() {
        List<CustomerProduct> customerProducts = Lists.newArrayList(CustomerProduct.builder().build());
        Mockito.when(productService.getCustomerProducts(Mockito.eq(1L), Mockito.eq(2L))).thenReturn(customerProducts);

        ResponseEntity<List<CustomerProduct>> responseEntity = customerController.getCustomerProducts(1L, 2L);

        Assert.assertEquals(responseEntity.getStatusCodeValue(), 200);
        Assert.assertEquals(customerProducts, responseEntity.getBody());
    }

    @Test
    @DisplayName("Should return 400 when products are not available.")
    public void getCustomerProducts_whenProductsNotAvailable() {
        Mockito.when(productService.getCustomerProducts(Mockito.eq(1L), Mockito.eq(2L))).thenReturn(new ArrayList<>());

        ResponseEntity<List<CustomerProduct>> responseEntity = customerController.getCustomerProducts(1L, 2L);

        Assert.assertEquals(responseEntity.getStatusCodeValue(), 400);
    }
}