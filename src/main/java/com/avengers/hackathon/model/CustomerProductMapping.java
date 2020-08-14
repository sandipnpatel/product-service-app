package com.avengers.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @Id
    @Column(name =  "ID")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "MATURITY_AMOUNT")
    private BigDecimal maturityAmount;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
}
