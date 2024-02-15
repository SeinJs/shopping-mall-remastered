package com.nhnacademy.shoppingmall.domain;

import com.nhnacademy.shoppingmall.entity.Category;

import java.math.BigDecimal;

public interface ProductDto {
    String getModelName();
    String getProductImage();
    BigDecimal getUnitCost();
    String getCategory_CategoryName();
}
