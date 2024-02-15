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
    @Column(name = "point_history_id")
    private Integer pointHistoryId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @Column(name = "points_used")
    private Integer pointsUsed;
    @Column(name = "remaining_points")
    private Integer remainingPoints;
    @Column(name = "order_date")
    private LocalDateTime orderDate;

}
