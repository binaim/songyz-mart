package com.biniam.orderservice.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemsDto {
    private long id;
    private String orederName;
    //private String skucode;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal totalPrice;
    private String orderPaymentMethod;
    private String orderPaymentStatus;
    private String orderStatus;
    private LocalDateTime expirationDate;
    private LocalDateTime orderDate;
    private Boolean Expired;
    private String orderDescription;

}
