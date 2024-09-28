package com.biniam.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Address {
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String aptNumber;

}