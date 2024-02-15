package com.nhnacademy.shoppingmall.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderDetails {

    @EmbeddedId
    private Pk pk;
    private Integer quantity;
    @Column(name = "unit_cost")
    private BigDecimal unitCost;

    @MapsId("orderId")
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @MapsId("productId")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @EqualsAndHashCode
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {
        @Column(name = "order_id")
        private Integer orderId;
        @Column(name = "product_id")
        private Integer productId;
    }

}
