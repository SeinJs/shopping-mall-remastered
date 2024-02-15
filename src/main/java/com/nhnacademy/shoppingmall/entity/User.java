package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_birth")
    private String userBirth;
    @Column(name = "user_auth")
    private String userAuth;
    @Column(name = "user_point")
    private Integer userPoint;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "latest_login_at")
    private LocalDateTime latestLoginAt;
    private Integer addresses;

    @OneToMany(mappedBy = "user")
    private List<PointUsageHistory> pointUsageHistories;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Address> addressList;
}
