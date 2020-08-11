package com.avengers.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "CUSTOMER_PRODUCT")
public class CustomerProductMapping {
    @EmbeddedId
    private CustomerProductId customerProductId;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "MATURITY_AMOUNT")
    private BigDecimal maturityAmount;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
}
