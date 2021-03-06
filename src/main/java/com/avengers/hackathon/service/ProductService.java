package com.avengers.hackathon.service;

import com.avengers.hackathon.bean.CustomerProduct;
import com.avengers.hackathon.bean.Product;
import com.avengers.hackathon.bean.ProductGroup;
import com.avengers.hackathon.model.CustomerProductMapping;
import com.avengers.hackathon.model.ProductEntity;
import com.avengers.hackathon.repository.CustomerProductRepository;
import com.avengers.hackathon.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductService {

    private final CustomerProductRepository customerProductRepository;
    private final ProductRepository productRepository;

    public List<Product> getCustomerProducts(Long customerId) {

        List<Long> productIds = customerProductRepository.getProductIds(customerId);
        List<ProductEntity> productEntities = productRepository.findAllById(productIds);

        return productEntities.stream()
                .map(this::toProduct)
                .collect(Collectors.toList());
    }

    public List<CustomerProduct> getCustomerProducts(Long customerId, Long productId) {

        List<CustomerProductMapping> customerProductMappings = customerProductRepository.findCustomerProductMappingsById(customerId, productId);
        return customerProductMappings.stream()
                .map(this::toCustomerProduct)
                .collect(Collectors.toList());
    }

    private CustomerProduct toCustomerProduct(CustomerProductMapping customerProductMapping) {

        return com.avengers.hackathon.bean.CustomerProduct.builder()
                .id(customerProductMapping.getId())
                .customerId(customerProductMapping.getCustomer().getId())
                .productId(customerProductMapping.getProduct().getId())
                .productName(customerProductMapping.getProduct().getName())
                .accountNumber(customerProductMapping.getAccountNumber())
                .interestRate(customerProductMapping.getProduct().getInterestRate())
                .amount(customerProductMapping.getAmount())
                .maturityAmount(customerProductMapping.getMaturityAmount())
                .build();
    }

    private Product toProduct(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .group(ProductGroup.fromName(productEntity.getProductGroup()))
                .build();
    }
}
