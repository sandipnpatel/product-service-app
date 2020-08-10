package com.ing.product.bean;

import lombok.Data;
import lombok.Builder;

@Builder
@Data
public class Product {

    private Long id;
    private String name;
    private ProductGroup group;


}
