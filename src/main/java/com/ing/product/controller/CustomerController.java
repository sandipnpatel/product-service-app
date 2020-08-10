package com.ing.product.controller;

import com.ing.product.bean.CustomerProduct;
import com.ing.product.bean.Product;
import com.ing.product.exceptionhandling.CustomizedResponseExceptionHandler;
import com.ing.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Api(tags = "ING Customer Product API")
@RestController
@RequestMapping(value = "v1/customers")
@AllArgsConstructor
@Validated
public class CustomerController extends CustomizedResponseExceptionHandler {

    private ProductService productService;

    @ApiOperation(value = "Get All Customer's products")
    @GetMapping(value = "/{customerId}/products", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Product>> getAllProducts(@NonNull @PathVariable Long customerId) {

        List<Product> products = productService.getCustomerProducts(customerId);
        if(products == null || products.size() ==0) {
            return ResponseEntity.badRequest().build();
        } else {
            return Optional.of(productService.getCustomerProducts(customerId))
                    .map(productList -> ResponseEntity.status(HttpStatus.OK).body(productList))
                    .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
        }
    }

    @ApiOperation(value = "Get Customer products")
    @GetMapping(value = "/{customerId}/products/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CustomerProduct>> getCustomerProducts(@NonNull @PathVariable Long customerId,
                                                             @NonNull @PathVariable Long productId) {
        List<CustomerProduct> customerProducts = productService.getCustomerProducts(customerId, productId);
        if(customerProducts == null || customerProducts.size() ==0) {
            return ResponseEntity.badRequest().build();
        } else {
            return Optional.of(customerProducts)
                    .map(customerProductList -> ResponseEntity.status(HttpStatus.OK).body(customerProductList))
                    .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
        }

    }
}
