package com.biniam.orderservice.OrderServiceInterface;

import com.biniam.orderservice.dto.OrderLineRequest;
import com.biniam.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrderServiceInterface {
    public void persistOrder(OrderLineRequest orderLineRequest);
    public void getOrder(long id);
    public void deleteOrder(long id);
    public void updateOrder(long id, OrderLineRequest orderLineRequest);
    public List<OrderLineRequest> getAllOrders();

}
