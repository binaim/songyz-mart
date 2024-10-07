package com.biniam.orderservice.controller;

import com.biniam.orderservice.dto.OrderLineRequest;
import com.biniam.orderservice.serviceImpl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderLineRequest orderLineRequest) {
        orderService.persistOrder(orderLineRequest);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public String getOrder( @PathVariable long id) {
        orderService.getOrder(id);
        return "Order";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable long id) {
        orderService.deleteOrder(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@PathVariable long id, @RequestBody OrderLineRequest orderLineRequest) {
        orderService.updateOrder(id, orderLineRequest);
    }

//    @GetMapping("/getAllOrders")
//    @ResponseStatus(HttpStatus.OK)
//    public String getAllOrders(@PathVariable long id) {
//        orderService.getAllOrders();
//        return "All Orders";
//    }
       @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderLineRequest>> getAllOrders() {
        List<OrderLineRequest> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}

