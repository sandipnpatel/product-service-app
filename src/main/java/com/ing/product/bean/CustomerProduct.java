package com.ing.product.bean;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CustomerProduct {

    private Long id;
    private String name;
    private String accountNumber;
    private BigDecimal interestRate;
    private BigDecimal amount;
    private BigDecimal maturityAmount;
}
