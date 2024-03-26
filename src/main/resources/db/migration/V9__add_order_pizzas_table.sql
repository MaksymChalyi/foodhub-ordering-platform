CREATE TABLE IF NOT EXISTS order_pizzas
(
    order_id BIGINT NOT NULL,
    pizza_id BIGINT NOT NULL,
    PRIMARY KEY (order_id, pizza_id),
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (pizza_id) REFERENCES pizzas (id)
);
