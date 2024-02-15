package com.nhnacademy.shoppingmall.repository;

import com.nhnacademy.shoppingmall.entity.Order;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface OrderRepositoryCustom {
    List<Order> getOrderAndOrderDetails();
}
