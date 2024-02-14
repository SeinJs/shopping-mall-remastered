package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OrderID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    private LocalDateTime OrderDate;
    private LocalDateTime ShipDate;

    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;

    @OneToMany(mappedBy = "order")
    private List<PointUsageHistory> pointUsageHistories;
}
