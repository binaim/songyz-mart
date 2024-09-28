package com.biniam.orderservice.service;

import com.biniam.orderservice.model.Order;
import com.biniam.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdreService {
    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getAllOrders() {

        return  orderRepository.findAll();

    }
}
