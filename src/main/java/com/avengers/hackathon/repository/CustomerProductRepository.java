package com.avengers.hackathon.repository;

import com.avengers.hackathon.model.CustomerProductMapping;

import java.util.List;

public interface CustomerProductRepository {

    List<Long> getProductIds(Long customerId);

    List<CustomerProductMapping> findCustomerProductMappingsById(Long customerId, Long productId);
}
