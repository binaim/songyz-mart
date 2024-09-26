package com.biniam.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
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
