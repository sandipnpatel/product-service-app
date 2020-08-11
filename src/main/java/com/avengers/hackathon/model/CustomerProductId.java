package com.avengers.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Embeddable
public class CustomerProductId implements Serializable {
    @Column(name = "CUSTOMER_ID")
    private long customerId;
    @Column(name = "PRODUCT_ID")
    private long productId;
}