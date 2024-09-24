package com.biniam.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Currency;
import java.util.List;
@Document
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private Enum category;
    private double price;
    private Currency currency;
    private boolean availability;
    @DBRef
    private List<Variant> variants;
}
