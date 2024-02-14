package com.nhnacademy.shoppingmall.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
@Getter
@Setter
@Entity
public class OrderDetails {

    @EmbeddedId
    private Pk pk;
    private Integer Quantity;
    private BigDecimal UnitCost;

    @MapsId("OrderID")
    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;

    @MapsId("ProductID")
    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    @EqualsAndHashCode
    @Embeddable
    public static class Pk implements Serializable {
        private Integer OrderID;
        private Integer ProductID;
    }

}
