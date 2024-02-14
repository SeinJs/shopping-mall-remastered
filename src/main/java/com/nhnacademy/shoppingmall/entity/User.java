package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Users")
public class User {

    @Id
    private String UserID;
    private String UserName;
    private String UserPassword;
    private String UserBirth;
    private String UserAuth;
    private Integer UserPoint;
    private LocalDateTime CreatedAt;
    private LocalDateTime LatestLoginAt;
    private Integer Addresses;

    @OneToMany(mappedBy = "user")
    private List<PointUsageHistory> pointUsageHistories;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Address> addressList;
}
