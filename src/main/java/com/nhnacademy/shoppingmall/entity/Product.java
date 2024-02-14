package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ProductID;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;

    private String ModelNumber;
    private String ModelName;
    private String ProductImage;
    private BigDecimal UnitCost;
    private String Description;

    @OneToMany(mappedBy = "product")
    private List<OrderDetails> orderDetails;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToMany(mappedBy = "product")
    private List<ShoppingCart> shoppingCarts;
}
