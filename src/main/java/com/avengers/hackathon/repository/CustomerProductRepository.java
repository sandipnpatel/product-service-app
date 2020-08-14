package com.avengers.hackathon.repository;

import com.avengers.hackathon.model.CustomerProductMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerProductRepository extends JpaRepository<CustomerProductMapping, Long> {

    @Query("SELECT DISTINCT cp.product.id FROM CustomerProductMapping cp where cp.customer.id = :customerId")
    List<Long> getProductIds(Long customerId);

    @Query("FROM CustomerProductMapping cp where cp.customer.id=:customerId and cp.product.id=:productId")
    List<CustomerProductMapping> findCustomerProductMappingsById(Long customerId, Long productId);
}
