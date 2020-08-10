package com.avengers.hackathon.bean;

import lombok.Data;
import lombok.Builder;

@Builder
@Data
public class Product {

    private Long id;
    private String name;
    private ProductGroup group;


}
