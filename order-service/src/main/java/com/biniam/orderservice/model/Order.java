package com.biniam.orderservice.model;

import com.biniam.orderservice.dto.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Data
@Document(collection = "orders")
public class Order {


   @Indexed(unique = true)
   @Field("order_number")
    private String orderNumber;

   @Field("order_date")
   private LocalDateTime orderDate;
    @Id
    private Long id;
    private String oredersName;
    private String orderDescription;
    private String orderLocation;
    // private String orderCustomerName;
    private String orderTotalPrice;
   // @Enumerated(EnumType.STRING)
    private PaymentType paymentMethod;
   // @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    //@Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private String orderDeliveryStatus;
    private String orderDeliveryDate;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<OrderItems> orderItemList;
        @Field("shipping_address")
    private Address shippingAddress;

    @Field("billing_address")
    private Address billingAddress;





//    @Field("customer_id")
//    private String customerId;
//
//    @Field("status")
//    private OrderStatus status;
//
//    @Field("total_amount")
//    private Double totalAmount;
//
//    @Field("order_items")
//    private List<OrderItem> orderItems;
//
//    @Field("shipping_address")
//    private Address shippingAddress;
//
//    @Field("billing_address")
//    private Address billingAddress;
//
//    @Field("payment_method")
//    private String paymentMethod;
//
//    @Field("shipping_method")
//    private String shippingMethod;
}