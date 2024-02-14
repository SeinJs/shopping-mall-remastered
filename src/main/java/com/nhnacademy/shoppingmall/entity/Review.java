package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ReviewID;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    private Integer Rating;
    private String Comments;

}
