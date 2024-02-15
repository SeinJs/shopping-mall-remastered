package com.nhnacademy.shoppingmall.repository;

import com.nhnacademy.shoppingmall.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class OrderRepositoryImpl extends QuerydslRepositorySupport implements OrderRepositoryCustom {
    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<Order> getOrderAndOrderDetails() {
        QOrder order = QOrder.order;
        QOrderDetails orderDetails = QOrderDetails.orderDetails;
        QProduct product = QProduct.product;

        return from(order)
                .leftJoin(order.orderDetails, orderDetails).fetchJoin()
                .leftJoin(orderDetails.product, product).fetchJoin()
                .fetch();
    }
}
