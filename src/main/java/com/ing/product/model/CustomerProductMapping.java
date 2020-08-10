package com.ing.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER_PRODUCT")
public class CustomerProductMapping {
    @EmbeddedId
    private CustomerProductId customerProductId;
    @Column(name =  "AMOUNT")
    private BigDecimal amount;
    @Column(name =  "MATURITY_AMOUNT")
    private BigDecimal maturityAmount;
    @Column(name =  "ACCOUNT_NUMBER")
    private String accountNumber;
}
