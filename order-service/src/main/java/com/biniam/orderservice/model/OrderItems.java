package com.biniam.orderservice.model;

//import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//import javax.persistence.Id;
@Data
//@Table(name = "order_line_items")
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order_line_items")
@Setter
@Getter
public class OrderItems {
         @Id
         private long id;
         private String orederName;
         private BigDecimal price;
         private Integer quantity;
         private BigDecimal totalPrice;
         private String orderPaymentMethod;
         private String orderPaymentStatus;
         private String orderStatus;
         private String expirationDate;
         private LocalDateTime orderDate;
         private Boolean Expired;




}
