package com.avengers.hackathon.bean;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CustomerProduct {

    private Long id;
    private Long customerId;
    private Long productId;
    private String productName;
    private String accountNumber;
    private BigDecimal interestRate;
    private BigDecimal amount;
    private BigDecimal maturityAmount;
}
