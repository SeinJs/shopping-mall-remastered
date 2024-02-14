package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AddressID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    private String Street;
    private String City;
    private String State;
    private String ZipCode;
}
