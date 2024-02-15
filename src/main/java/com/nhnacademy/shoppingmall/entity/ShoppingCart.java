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
    @Column(name = "record_id")
    private Integer recordId;

    @Column(name = "cart_id")
    private String cartId;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;
}
