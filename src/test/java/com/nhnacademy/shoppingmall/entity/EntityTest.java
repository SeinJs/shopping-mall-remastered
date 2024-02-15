package com.nhnacademy.shoppingmall.entity;

import com.nhnacademy.shoppingmall.config.RootConfig;
import com.nhnacademy.shoppingmall.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class EntityTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void UserEntityTest() {
        User user = entityManager.find(User.class, "admin");
        assertThat(user.getUserID()).isEqualTo("admin");

        User newUser = new User();
        newUser.setUserID("user1");
        newUser.setUserName("사용자1");
        newUser.setUserPassword("user1");
        newUser.setUserAuth("ROLE_USER");
        newUser.setUserBirth("19990909");
        newUser.setUserPoint(1000000);
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setLatestLoginAt(null);
        newUser.setAddresses(0);

        entityManager.persist(newUser);

        User selectedUser = entityManager.find(User.class, "user1");
        assertThat(newUser.getUserID()).isEqualTo(selectedUser.getUserID());
    }

    @Test
    void CategoryEntityTest() {
        Category category = entityManager.find(Category.class, 1);
        assertThat(category.getCategoryID()).isEqualTo(1);
        assertThat(category.getCategoryName()).isEqualTo("Aeon");
    }

    @Test
    void ProductEntityTest() {
        Product newProduct = entityManager.find(Product.class, 1);
        assertThat(newProduct.getProductID()).isEqualTo(1);
        assertThat(newProduct.getModelName()).isEqualTo("Nous");
    }

    @Test
    void AddressEntityTest() {
        Address newAddress = entityManager.find(Address.class, 1);
        assertThat(newAddress.getAddressID()).isEqualTo(1);
        assertThat(newAddress.getStreet()).isEqualTo("7th Street");
    }

    @Test
    void PointUsageHistoryEntityTest() {
        PointUsageHistory newPointUsageHistory = entityManager.find(PointUsageHistory.class, 1);
        assertThat(newPointUsageHistory.getPointHistoryID()).isEqualTo(1);
        assertThat(newPointUsageHistory.getRemainingPoints()).isEqualTo(991000);
    }

    @Test
    void ReviewEntityTest() {
        Review newReview = entityManager.find(Review.class, 1);
        assertThat(newReview.getReviewID()).isEqualTo(1);
        assertThat(newReview.getComments()).isEqualTo("nice");
    }

    @Test
    void OrderEntityTest() {
        Order newOrder = entityManager.find(Order.class, 1);
        assertThat(newOrder.getOrderID()).isEqualTo(1);
        assertThat(newOrder.getUser().getUserID()).isEqualTo("admin");
    }
    @Test
    void OrderDetailsEntityTest() {
        OrderDetails.Pk pk = new OrderDetails.Pk(1,1);

        OrderDetails newOrderDetails = entityManager.find(OrderDetails.class, pk);
        assertThat(newOrderDetails.getOrder().getOrderID()).isEqualTo(1);
        assertThat(newOrderDetails.getQuantity()).isEqualTo(1);
    }
    @Test
    void ShoppingCartEntityTest() {
        ShoppingCart newShoppingCart = entityManager.find(ShoppingCart.class, 1);
        assertThat(newShoppingCart.getCartID()).isEqualTo("admin");
        assertThat(newShoppingCart.getRecordID()).isEqualTo(1);
    }
}