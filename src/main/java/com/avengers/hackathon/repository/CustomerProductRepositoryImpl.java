package com.avengers.hackathon.repository;

import com.avengers.hackathon.model.CustomerProductMapping;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerProductRepositoryImpl implements  CustomerProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Long> getProductIds(Long customerId) {
        return entityManager.createQuery("SELECT customerProductId.productId from CustomerProductMapping where customerProductId.customerId=:customerId"
                , Long.class).setParameter("customerId", customerId).getResultList();
    }

    @Override
    public List<CustomerProductMapping> findCustomerProductMappingsById(Long customerId, Long productId) {
        return entityManager.createQuery("from CustomerProductMapping " +
                        "where customerProductId.customerId=:customerId " +
                        "and customerProductId.productId=:productId"
                , CustomerProductMapping.class)
                .setParameter("customerId", customerId)
                .setParameter("productId", productId)
                .getResultList();
    }
}
