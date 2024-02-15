package com.nhnacademy.shoppingmall.repository;

import com.nhnacademy.shoppingmall.domain.ProductDto;
import com.nhnacademy.shoppingmall.domain.ProductNameOnly;
import com.nhnacademy.shoppingmall.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByModelNameLike(String modelName);
    @Query("select p from Product p where p.category.categoryName = ?1")
    List<Product> getProductsByCategory_CategoryName(String categoryName);
//    List<ProductDto> findAllBy();
    Page<ProductNameOnly> getAllBy(Pageable pageable);
}
