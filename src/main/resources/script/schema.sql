CREATE TABLE IF NOT EXISTS Users
(
    user_id        varchar(50)  NOT NULL COMMENT '아이디',
    user_name      varchar(50)  NOT NULL COMMENT '이름',
    user_password  varchar(200) NOT NULL COMMENT 'mysql password 사용',
    user_birth     varchar(8)   NOT NULL COMMENT '생년월일 : 19840503',
    user_auth      varchar(10)  NOT NULL COMMENT '권한: ROLE_ADMIN,ROLE_USER',
    user_point     int          NOT NULL COMMENT 'default : 1000000',
    created_at     datetime     NOT NULL COMMENT '가입일자',
    latest_login_at datetime DEFAULT NULL COMMENT '마지막 로그인 일자',
    addresses     INT      DEFAULT 0 COMMENT 'Number of addresses user can manage',
    PRIMARY KEY (user_id)
);
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회원';

CREATE TABLE IF NOT EXISTS Categories
(
    category_id   INT auto_increment,
    category_name varchar(50),

    CONSTRAINT pk_Categories PRIMARY KEY (category_id)
);
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='종류';

CREATE TABLE IF NOT EXISTS Products
(
    product_id    INT auto_increment,
    category_id   INT,
    model_number  nvarchar(10),
    model_name    nvarchar(120),
    product_image nvarchar(30),
    unit_cost     decimal(15),
    description  text,

    CONSTRAINT pk_Products PRIMARY KEY (product_id),
    CONSTRAINT fk_Products_Categories FOREIGN KEY (category_id) REFERENCES Categories (category_id)
);
        -- )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상품';

CREATE TABLE IF NOT EXISTS Reviews
(
    review_id  int auto_increment,
    product_id int,
    user_id    varchar(50),
    rating    int,
    comments  text,

    CONSTRAINT pk_ReviewID PRIMARY KEY (review_id),
    CONSTRAINT fk_Review_Products FOREIGN KEY (product_id) REFERENCES Products (product_id),
    CONSTRAINT fk_Review_User FOREIGN KEY (user_id) REFERENCES Users (user_id)
);
--     ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='리뷰';

CREATE TABLE IF NOT EXISTS Orders
(
    order_id   int auto_increment,
    user_id    varchar(50),
    order_date Datetime,
    ship_date  Datetime,

    CONSTRAINT pk_Orders PRIMARY KEY (order_id),
    CONSTRAINT fk_Orders_UserID FOREIGN KEY (user_id) REFERENCES Users (user_id)
);
--     ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='주문';

CREATE TABLE IF NOT EXISTS OrderDetails
(
    order_id   int,
    product_id int,
    quantity  int,
    unit_cost  decimal(15),

    CONSTRAINT pk_OrderDetails PRIMARY KEY (order_id, product_id),
    CONSTRAINT fk_OrderDetails_Orders FOREIGN KEY (order_id) REFERENCES Orders (order_id),
    CONSTRAINT fk_OrderDetails_Products FOREIGN KEY (product_id) REFERENCES Products (product_id)
);
--     ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='주문상세';

CREATE TABLE IF NOT EXISTS ShoppingCart
(
    record_id    int auto_increment,
    cart_id      nvarchar(150),
    quantity    int,
    product_id   int,
    date_created Datetime DEFAULT NOW(),

    CONSTRAINT pk_RecordID PRIMARY KEY (record_id),
    CONSTRAINT fk_cart_product_id FOREIGN KEY (product_id) REFERENCES Products (product_id)
);
--     ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='장바구니';

CREATE TABLE IF NOT EXISTS Addresses
(
    address_id INT AUTO_INCREMENT,
    user_id    varchar(50)  NOT NULL,
    street    varchar(255) NOT NULL,
    city      varchar(50)  NOT NULL,
    state     varchar(50),
    zipCode   varchar(20),
    PRIMARY KEY (address_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);
--     ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='주소';

CREATE TABLE IF NOT EXISTS PointUsageHistory
(
    point_history_id  INT AUTO_INCREMENT PRIMARY KEY,
    user_id          VARCHAR(50),
    order_id         INT,
    points_used      INT,
    remaining_points INT,
    order_date       DATETIME,
    CONSTRAINT fk_PointUsageHistory_UserID FOREIGN KEY (user_id) REFERENCES Users (user_id),
    CONSTRAINT fk_PointUsageHistory_order_id FOREIGN KEY (order_id) REFERENCES Orders (order_id)
);
--     ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

merge INTO `Users` key(`user_id`)
    VALUES ('admin', '관리자', '12345', '0000000', 'ROLE_ADMIN', 1000000, now(), null, 0);

-- INSERT INTO Users (UserID, UserName, UserPassword, UserBirth, UserAuth, UserPoint, CreatedAt, LatestLoginAt, Addresses)
-- VALUES ('admin', '관리자', '12345', '0000000', 'ROLE_ADMIN', 1000000, '2024-02-13 12:00:00', null, 0);
merge INTO `Categories` key(`category_id`)
    VALUES (1, 'Aeon');

merge INTO `Products` key(`product_id`)
    VALUES (1, 1, '004950', 'Nous', '/image', 9000, 'Nous');

merge INTO `Addresses` key(`address_id`)
    VALUES (1, 'admin', '7th Street', 'England is my city', 'Nowhere', '09000');

merge INTO `Orders` key(`order_id`)
    VALUES (1, 'admin', '2024-01-13 12:00:00', '2024-01-13 12:00:00');

merge INTO `OrderDetails` key(`order_id`, `product_id`)
    VALUES (1, 1, 1, 9000);

merge INTO `ShoppingCart` key(`record_id`)
    VALUES (1, 'admin', 1, 1, '2024-01-13 12:00:00');

merge INTO `PointUsageHistory` key(`point_history_id`)
    VALUES (1, 'admin', 1, 9000, 991000, '2024-01-13 12:00:00');

merge INTO `Reviews` key(`review_id`)
    VALUES (1, 1, 'admin', 4, 'nice');