ALTER TABLE pizzas
    ADD COLUMN order_id BIGINT REFERENCES orders (id);