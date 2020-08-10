package com.ing.product.bean;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductGroup {

    MORTGAGE("Mortgage"),
    PAYMENTS("Payments"),
    SAVINGS("Savings");

    private String name;

    ProductGroup(String name) {
        this.name = name;
    }

    @JsonValue
    public String getJsonValue() {
        return this.name;
    }
}
