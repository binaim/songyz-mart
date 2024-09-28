package com.biniam.inventoryservice.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String aptNumber;
    private String country;

}
