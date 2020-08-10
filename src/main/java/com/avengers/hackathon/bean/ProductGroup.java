package com.avengers.hackathon.bean;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ProductGroup {

    MORTGAGE("pg_mortgage"),
    PAYMENTS("pg_payments"),
    SAVINGS("pg_savings");

    private String val;

    ProductGroup(String val) {
        this.val = val;
    }

    @JsonValue
    public String getJsonValue() {
        return this.val;
    }

    public static ProductGroup fromName(final String groupName) {
        return Arrays.stream(ProductGroup.values())
                .filter(value -> value.val.equals(groupName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Invalid groupName: %s", groupName)));

    }
}
