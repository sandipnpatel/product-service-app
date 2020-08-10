package com.ing.product.model;

import com.ing.product.bean.ProductGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {
    @Id
    @Column(name =  "ID")
    private long id;
    @Column(name =  "TYPE")
    private String type;
    @Column(name =  "NAME")
    private String name;
    @Column(name =  "INTEREST_RATE")
    private BigDecimal interestRate;
}
