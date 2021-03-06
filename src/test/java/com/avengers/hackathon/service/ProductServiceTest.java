package com.avengers.hackathon.service;

import com.avengers.hackathon.bean.CustomerProduct;
import com.avengers.hackathon.bean.Product;
import com.avengers.hackathon.bean.ProductGroup;
import com.avengers.hackathon.model.Customer;
import com.avengers.hackathon.model.CustomerProductMapping;
import com.avengers.hackathon.model.ProductEntity;
import com.avengers.hackathon.repository.CustomerProductRepository;
import com.avengers.hackathon.repository.ProductRepository;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private CustomerProductRepository customerProductRepository;

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("Should return list of Products from repository.")
    public void getCustomerProducts_shouldReturnProductsFromRepository() {
        List<Long> productIds = Lists.newArrayList(1L, 2L);
        Mockito.when(customerProductRepository.getProductIds(Mockito.eq(1L))).thenReturn(productIds);

        List<ProductEntity> productList = Lists.newArrayList(
                ProductEntity.builder()
                        .id(1L)
                        .name("p_orange_savings")
                        .productGroup("pg_savings")
                        .interestRate(BigDecimal.valueOf(2.4))
                        .build(),
                ProductEntity.builder()
                        .id(2L)
                        .name("p_interest_only_mortgage")
                        .productGroup("pg_mortgage")
                        .interestRate(BigDecimal.valueOf(1.7))
                        .build());

        Mockito.when(productRepository.findAllById(Mockito.eq(productIds))).thenReturn(productList);

        List<Product> actual = productService.getCustomerProducts(1L);

        List<Product> expected = Lists.newArrayList(
                Product.builder()
                        .id(1L)
                        .name("p_orange_savings")
                        .group(ProductGroup.SAVINGS)
                        .build(),
                Product.builder()
                        .id(2L)
                        .name("p_interest_only_mortgage")
                        .group(ProductGroup.MORTGAGE)
                        .build());

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        Mockito.verify(customerProductRepository, Mockito.times(1)).getProductIds(Mockito.eq(1L));
        Mockito.verify(productRepository, Mockito.times(1)).findAllById(Mockito.eq(productIds));
    }

    @Test
    @DisplayName("Should return empty list when products are not available in repository.")
    public void getCustomerProducts_returnEmptyListWhenProductsAreNotInRepository() {

        Mockito.when(customerProductRepository.getProductIds(Mockito.eq(1L))).thenReturn(new ArrayList<>());
        Mockito.when(productRepository.findAllById(Mockito.eq(new ArrayList<>()))).thenReturn(new ArrayList<>());

        List<Product> actual = productService.getCustomerProducts(1L);

        Assert.assertEquals(0, actual.size());

        Mockito.verify(customerProductRepository, Mockito.times(1)).getProductIds(Mockito.eq(1L));
    }


    @Test
    @DisplayName("Should return list of CustomerProducts from repository.")
    public void testGetCustomerProducts_shouldReturnCustomerProductsFromRepository() {

        List<CustomerProductMapping> customerProductMappings = Lists.newArrayList(CustomerProductMapping.builder()
                .id(3L)
                .customer(Customer.builder().id(1L).build())
                .product(ProductEntity.builder().id(2L).name("p_interest_only_mortgage").interestRate(BigDecimal.valueOf(1.7)).build())
                .accountNumber("1234567890")
                .amount(BigDecimal.valueOf(1000))
                .maturityAmount(BigDecimal.valueOf(1050))
                .build());

        Mockito.when(customerProductRepository.findCustomerProductMappingsById(Mockito.eq(1L), Mockito.eq(2L))).thenReturn(customerProductMappings);

        List<CustomerProduct> actual = productService.getCustomerProducts(1L, 2L);

        List<CustomerProduct> expected = Lists.newArrayList(CustomerProduct.builder()
                .id(3L)
                .customerId(1L)
                .productId(2L)
                .accountNumber("1234567890")
                .productName("p_interest_only_mortgage")
                .amount(BigDecimal.valueOf(1000))
                .maturityAmount(BigDecimal.valueOf(1050))
                .interestRate(BigDecimal.valueOf(1.7))
                .build());

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        Mockito.verify(customerProductRepository, Mockito.times(1)).findCustomerProductMappingsById(Mockito.eq(1L), Mockito.eq(2L));
    }

    @Test
    @DisplayName("Should return empty list when CustomerProducts are not available in repository.")
    public void testGetCustomerProducts_returnEmptyListWhenCustomerProductsAreNotInRepository() {
        Mockito.when(customerProductRepository.findCustomerProductMappingsById(Mockito.eq(1L), Mockito.eq(2L))).thenReturn(new ArrayList<>());

        List<CustomerProduct> actual = productService.getCustomerProducts(1L, 2L);

        Assert.assertEquals(0, actual.size());

        Mockito.verify(customerProductRepository, Mockito.times(1)).findCustomerProductMappingsById(Mockito.eq(1L), Mockito.eq(2L));
    }

}