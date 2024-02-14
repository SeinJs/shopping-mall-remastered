package com.nhnacademy.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class PointUsageHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PointHistoryID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;

    private Integer PointsUsed;
    private Integer RemainingPoints;
    private LocalDateTime OrderDate;

}
