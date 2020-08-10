package com.ing.product.service;

import com.ing.product.bean.CustomerProduct;
import com.ing.product.bean.Product;
import com.ing.product.bean.ProductGroup;
import com.ing.product.model.CustomerProductMapping;
import com.ing.product.model.ProductEntity;
import com.ing.product.repository.CustomerProductRepository;
import com.ing.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private CustomerProductRepository customerProductRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getCustomerProducts(Long customerId) {

        List<Long> productIds = customerProductRepository.getProductIds(customerId);
        List<ProductEntity> productEntities = productRepository.findAllById(productIds);

        return productEntities.stream()
                .map(this::toProduct)
                .collect(Collectors.toList());
    }

    public List<CustomerProduct> getCustomerProducts(Long customerId, Long productId) {

        List<CustomerProductMapping>  customerProductMappings = customerProductRepository.findCustomerProductMappingsById(customerId, productId);
        return customerProductMappings.stream()
                .map(this::toCustomerProduct)
                .collect(Collectors.toList());
    }

    private CustomerProduct toCustomerProduct(CustomerProductMapping customerProductMapping) {

        Optional<ProductEntity> productEntity = productRepository.findById(customerProductMapping.getCustomerProductId().getProductId());

        return CustomerProduct.builder()
                .id(customerProductMapping.getCustomerProductId().getProductId())
                .name(productEntity.map(ProductEntity::getName).orElseThrow(() -> new RuntimeException("Invalid Product Id:"+customerProductMapping.getCustomerProductId().getProductId())))
                .accountNumber(customerProductMapping.getAccountNumber())
                .interestRate(productEntity.get().getInterestRate())
                .amount(customerProductMapping.getAmount())
                .maturityAmount(customerProductMapping.getMaturityAmount())
                .build();
    }

    private Product toProduct(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .group(ProductGroup.valueOf(productEntity.getType()))
                .build();
    }
}
