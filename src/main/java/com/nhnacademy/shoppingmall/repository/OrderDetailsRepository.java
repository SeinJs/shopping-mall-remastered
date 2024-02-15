package com.nhnacademy.shoppingmall.repository;

import com.nhnacademy.shoppingmall.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetails.Pk> {
}
