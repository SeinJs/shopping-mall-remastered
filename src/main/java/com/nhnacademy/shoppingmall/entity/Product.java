package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "model_number")
    private String modelNumber;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "unit_cost")
    private BigDecimal unitCost;

    private String description;

    @OneToMany(mappedBy = "product")
    private List<OrderDetails> orderDetails;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToMany(mappedBy = "product")
    private List<ShoppingCart> shoppingCarts;
}
