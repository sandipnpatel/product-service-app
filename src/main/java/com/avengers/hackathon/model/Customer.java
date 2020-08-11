package com.avengers.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
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
