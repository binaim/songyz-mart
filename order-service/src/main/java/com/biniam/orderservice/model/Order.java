package com.biniam.orderservice.model;

import com.biniam.orderservice.dto.Address;
import com.biniam.orderservice.dto.OrderItem;
import com.biniam.orderservice.dto.OrderStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    @Indexed(unique = true)
    @Field("order_number")
    private String orderNumber;

    @Field("customer_id")
    private String customerId;

    @Field("order_date")
    private LocalDateTime orderDate;

    @Field("status")
    private OrderStatus status;

    @Field("total_amount")
    private Double totalAmount;

    @Field("order_items")
    private List<OrderItem> orderItems;

    @Field("shipping_address")
    private Address shippingAddress;

    @Field("billing_address")
    private Address billingAddress;

    @Field("payment_method")
    private String paymentMethod;

    @Field("shipping_method")
    private String shippingMethod;
}