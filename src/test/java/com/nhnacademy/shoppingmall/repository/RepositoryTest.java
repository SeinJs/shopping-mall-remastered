package com.nhnacademy.shoppingmall.repository;

import com.nhnacademy.shoppingmall.config.RootConfig;
import com.nhnacademy.shoppingmall.config.WebConfig;
import com.nhnacademy.shoppingmall.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class RepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PointUsageHistoryRepository pointUsageHistoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void addressRepositoryTest() {
        Address address = addressRepository.findById(1).get();
        assertThat(address).isNotNull();
    }

    @Test
    void categoryRepositoryTest() {
        Category newCategory = new Category();
        newCategory.setCategoryId(2);
        newCategory.setCategoryName("Food");
        categoryRepository.save(newCategory);

        List<Category> categoryList = categoryRepository.findAll();
        assertThat(categoryList).hasSize(2);
    }

    @Test
    void orderRepositoryTest() {
        Order order = orderRepository.findById(1).get();
        assertThat(order.getOrderId()).isEqualTo(1);

        Product product = productRepository.findById(1).get();
        assertThat(product.getProductId()).isEqualTo(1);

        OrderDetails orderDetails = orderDetailsRepository.findById(new OrderDetails.Pk(1,1)).get();
        assertThat(orderDetails.getOrder()).isEqualTo(order);
        assertThat(orderDetails.getProduct()).isEqualTo(product);
    }

    @Test
    void pointUsageHistoryRepositoryTest() {
        Order order = orderRepository.findById(1).get();
        assertThat(order.getOrderId()).isEqualTo(1);

        User user = userRepository.findById("admin").get();
        assertThat(user.getUserName()).isEqualTo("관리자");

        PointUsageHistory pointUsageHistory = pointUsageHistoryRepository.findById(1).get();
        assertThat(pointUsageHistory.getUser()).isEqualTo(user);
        assertThat(pointUsageHistory.getOrder()).isEqualTo(order);
    }

    @Test
    void reviewRepositoryTest() {
        Product product = productRepository.findById(1).get();
        assertThat(product.getProductId()).isEqualTo(1);

        User user = userRepository.findById("admin").get();
        assertThat(user.getUserName()).isEqualTo("관리자");

        Review review = reviewRepository.findById(1).get();
        assertThat(review.getProduct()).isEqualTo(product);
        assertThat(review.getUser()).isEqualTo(user);
    }

    @Test
    void shoppingCartRepositoryTest() {
        Product product = productRepository.findById(1).get();
        assertThat(product.getProductId()).isEqualTo(1);

        ShoppingCart shoppingCart = shoppingCartRepository.findById(1).get();
        assertThat(shoppingCart.getProduct()).isEqualTo(product);
        assertThat(shoppingCart.getCartId()).isEqualTo("admin");
    }
}