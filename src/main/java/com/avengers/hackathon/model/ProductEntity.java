package com.avengers.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "PRODUCT_GROUP")
    private String productGroup;
    @Column(name = "NAME")
    private String name;
    @Column(name = "INTEREST_RATE")
    private BigDecimal interestRate;
}
