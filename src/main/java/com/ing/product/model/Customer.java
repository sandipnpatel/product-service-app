package com.ing.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @Column(name =  "ID")
    private long id;
    @Column(name =  "FIRST_NAME")
    private String firstName;
    @Column(name =  "LAST_NAME")
    private String lastName;
}
