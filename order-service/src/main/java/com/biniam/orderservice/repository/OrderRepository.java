package com.biniam.orderservice.repository;

import com.biniam.orderservice.dto.OrderStatus;
import com.biniam.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Long> {
    Order findByOrderNumber(String orderNumber);
    List<Order> findByCustomerId(String customerId);
    List<Order> findByStatus(OrderStatus status);

}