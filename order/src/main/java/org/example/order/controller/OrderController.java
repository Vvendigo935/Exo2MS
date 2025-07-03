package org.example.order.controller;


import org.example.order.dto.OrderResponseDto;
import org.example.order.entity.Order;
import org.example.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    public OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrder(@PathVariable int id){
        Order order = orderService.getOrderById(id);

//        Order order2 = new Order();
//        order2.setId(id);
//        order2.setDescription("description");
        return orderService.orderToOrderResponseDto(order);
    }
}
