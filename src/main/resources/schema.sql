CREATE TABLE IF NOT EXISTS CUSTOMERS (
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(50) NOT NULL,
    surname      VARCHAR(50) NOT NULL,
    age          INT         NOT NULL,
    phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS ORDERS (
    id           INT AUTO_INCREMENT PRIMARY KEY,
    date         DATE           NOT NULL,
    customer_id  INT,
    product_name VARCHAR(100)   NOT NULL,
    amount       DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_customer
        FOREIGN KEY (customer_id)
            REFERENCES CUSTOMERS (id)
);