package com.ing.product.repository;

import com.ing.product.model.CustomerProductMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerProductRepository {

    List<Long> getProductIds(Long customerId);

    List<CustomerProductMapping> findCustomerProductMappingsById(Long customerId, Long productId);
}
