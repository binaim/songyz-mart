package com.biniam.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Currency;
import java.util.List;
@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private Category category;
    private double price;
    private Currency currency;
    private boolean availability;
    @DBRef
    private List<Variant> variants;
}
