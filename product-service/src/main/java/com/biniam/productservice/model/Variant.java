package com.biniam.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
@Document
public class Variant {
    @Id
    private String variantId;
    private String size;
    private String color;
    private String sku;
    private double price;
    private int stock;
    private String images;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
