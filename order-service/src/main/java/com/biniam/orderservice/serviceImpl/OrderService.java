package com.biniam.orderservice.serviceImpl;

import com.biniam.orderservice.OrderServiceInterface.OrderServiceInterface;
import com.biniam.orderservice.dto.OrderItemsDto;
import com.biniam.orderservice.dto.OrderLineRequest;
import com.biniam.orderservice.dto.PaymentStatus;
import com.biniam.orderservice.model.Order;
import com.biniam.orderservice.model.OrderItems;
import com.biniam.orderservice.repository.OrderRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
//import com.itextpdf.styledxmlparser.jsoup.nodes.Document;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderServiceInterface {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void persistOrder(OrderLineRequest orderLineRequest){
        Order order = new Order();
        List<OrderItems> orderItems;
       // if (orderLineRequest != null && orderLineRequest.getOrderLineItems().size() > 0) {
            try {
                orderItems = orderLineRequest.getOrderLineItems().stream()
                        .map(orderItemsDto -> {
                            OrderItems orderItems1 = new OrderItems();
                            orderItems1.setPrice(orderItemsDto.getPrice());
                            orderItems1.setOrderPaymentMethod(orderItemsDto.getOrderPaymentMethod());
                            orderItems1.setOrderPaymentStatus(orderItemsDto.getOrderPaymentStatus());
                            orderItems1.setOrderStatus(orderItemsDto.getOrderStatus());
                            orderItems1.setQuantity(orderItemsDto.getQuantity());
                            orderItems1.setOrederName(orderItemsDto.getOrederName());
                            return orderItems1;
                        }).collect(Collectors.toList());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            order.setOrderItemList(orderItems);
            orderRepository.save(order);
        }
    public void getOrder(long id) {
        orderRepository.findById(id);
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void updateOrder(long id, OrderLineRequest orderLineRequest) {
        Order order = orderRepository.findById(id).get();
        List<OrderItems> orderItems;
        try {
            orderItems = orderLineRequest.getOrderLineItems().stream()
                    .map(orderItemsDto -> {
                        OrderItems orderItems1 = new OrderItems();
                        orderItems1.setPrice(orderItemsDto.getPrice());
                        orderItems1.setOrderPaymentMethod(orderItemsDto.getOrderPaymentMethod());
                        orderItems1.setOrderPaymentStatus(orderItemsDto.getOrderPaymentStatus());
                        orderItems1.setOrderStatus(orderItemsDto.getOrderStatus());
                        orderItems1.setQuantity(orderItemsDto.getQuantity());
                        orderItems1.setOrederName(orderItemsDto.getOrederName());
                        return orderItems1;
                    }).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        order.setOrderItemList(orderItems);
        orderRepository.save(order);
    }

    @Override
    public List<OrderLineRequest> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        if (orders.size() > 0 && orders.get(0).getOrderItemList().size() > 0) {

            return orders.stream().map(order -> {
                OrderLineRequest orderLineRequest = new OrderLineRequest();
                // Calculate expiration date based on order date
                LocalDateTime expirationDate = order.getOrderDate().plusDays(15);
                boolean isExpired = LocalDateTime.now().isAfter(expirationDate);
                // Set expiration date and check if expired
                orderLineRequest.getOrderLineItems().forEach(orderItemsDto -> {
                    orderItemsDto.setExpirationDate(expirationDate);
                });
                orderLineRequest.getOrderLineItems().forEach(orderItemsDto -> {
                    orderItemsDto.setExpired(isExpired);
                });
//                order.getOrderItemList().forEach(orderItems -> {
//                    OrderItemsDto orderItemsDto = new OrderItemsDto();
//                    orderItemsDto.setPrice(orderItems.getPrice());
//                    orderItemsDto.setOrderPaymentMethod(orderItems.getOrderPaymentMethod());
//                    orderItemsDto.setOrderPaymentStatus(orderItems.getOrderPaymentStatus());
//                    orderItemsDto.setOrderStatus(orderItems.getOrderStatus());
//                    orderItemsDto.setQuantity(orderItems.getQuantity());
//                    orderItemsDto.setOrederName(orderItems.getOrederName());

                    List<OrderItemsDto> orderItemsDtos = order.getOrderItemList().stream()
                            .map(orderItems -> OrderItemsDto.builder()
                                    .price(orderItems.getPrice())
                                    .orderPaymentMethod(orderItems.getOrderPaymentMethod())
                                    .orderPaymentStatus(orderItems.getOrderPaymentStatus())
                                    .orderStatus(orderItems.getOrderStatus())
                                    .quantity(orderItems.getQuantity())
                                    .orederName(orderItems.getOrederName())
                                    .build())
                            .collect(Collectors.toList());

                    // If the order has expired and payment was completed, process refund
                    if (isExpired && PaymentStatus.COMPLETED.equals(PaymentStatus.valueOf(orderItemsDtos.get(getAllOrders().size()).getOrderPaymentStatus()))) {
                        // Process refund (this is just a placeholder for your actual refund logic)
                        orderItemsDtos.get(getAllOrders().size()).setOrderPaymentStatus(String.valueOf(PaymentStatus.CANCELED));
                        //  add refund logic here if you have one
                        // e.g. paymentService.processRefund(orderItems);
                    }
                    orderLineRequest.setOrderLineItems(Collections.singletonList(orderItemsDtos.get(getAllOrders().size())));
                    // Generate PDF with order description
                    //List<OrderLineRequest> orderLineRequests = null;
                    generateOrderPdf((List<OrderLineRequest>) orderItemsDtos.get(getAllOrders().size()));

                    // Generate PDF after processing the orders
                    // pdfService.generateOrderPdf(orderItemsDto);
                return orderLineRequest;
            }).collect(Collectors.toList());
        }
        return Collections.emptyList(); // Returning an empty list if there are no orders
    }

    private void generateOrderPdf(List<OrderLineRequest> orderLineRequests) {
        //String pdfFilePath = "order_details.pdf";
        try (PdfWriter writer = new PdfWriter("order_details.pdf");
             PdfDocument pdfDoc = new PdfDocument(writer);
             Document document = new Document(pdfDoc)) {

            // Add title and create a simple table
            document.add(new Paragraph("order_details.pdf"));
//            Table table = new Table(new float[]{4, 2, 2, 3, 4}).setWidthPercent(100);
            Table table = new Table(new float[]{4, 2, 2, 3, 4});
            table.setWidth(UnitValue.createPercentValue(100)); // This sets the table width to 100% of the page width
            Stream.of("Order Name", "Quantity", "Price", "Payment Method", "Description")
                    .forEach(header -> table.addHeaderCell(header));

            // Populate table rows with order details
            orderLineRequests.forEach(orderLineRequest -> orderLineRequest.getOrderLineItems().forEach(item -> {
                table.addCell(item.getOrederName());
                table.addCell(String.valueOf(item.getQuantity()));
                table.addCell(String.valueOf(item.getPrice()));
                table.addCell(item.getOrderPaymentMethod());
                table.addCell(item.getOrderDescription());
            }));

            // Add table to the document
            document.add(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


