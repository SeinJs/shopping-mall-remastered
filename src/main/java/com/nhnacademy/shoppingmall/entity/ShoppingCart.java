package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RecordID;

    private String CartID;
    private Integer Quantity;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    private LocalDateTime DateCreated;
}
