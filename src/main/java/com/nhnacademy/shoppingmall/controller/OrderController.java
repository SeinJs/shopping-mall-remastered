package com.nhnacademy.shoppingmall.controller;

import com.nhnacademy.shoppingmall.entity.Order;
import com.nhnacademy.shoppingmall.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public ResponseEntity<List<Order>> showAllOrders(){
        return ResponseEntity.ok().body(orderRepository.getOrderAndOrderDetails());
    }
}
