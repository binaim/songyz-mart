package com.biniam.orderservice.controller;

import com.biniam.orderservice.model.Order;
import com.biniam.orderservice.service.OrdreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/orders")
public class OrderController {

    private final OrdreService orderService;

    @Autowired
    public OrderController(OrdreService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){

        if (orderService.getAllOrders().isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orderService.getAllOrders());

    }
}
