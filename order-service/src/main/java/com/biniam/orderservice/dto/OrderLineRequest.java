package com.biniam.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderLineRequest {
    private List<OrderItemsDto> orderLineItems;
    //private Boolean Expired;
}


