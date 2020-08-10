package com.ing.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProductId implements Serializable {
    @Column(name =  "CUSTOMER_ID")
    private long customerId;
    @Column(name =  "PRODUCT_ID")
    private long productId;
}