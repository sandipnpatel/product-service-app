package com.avengers.hackathon.bean;

import com.avengers.hackathon.exception.InvalidGroupNameException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductGroupTest {

    @Test
    @DisplayName("Should convert to ProductGroup for valid value.")
    void testFromName_validValue() {
        ProductGroup productGroup = ProductGroup.fromName("pg_savings");
        Assert.assertEquals(ProductGroup.SAVINGS, productGroup);
    }

    @Test
    @DisplayName("Should throw InvalidGroupNameException for invalid value.")
    void testFromName_invalidValue() {

        Assertions.assertThrows(InvalidGroupNameException.class, () -> {
            ProductGroup.fromName("savings");
        });
    }
}