CREATE TABLE orders
(
    id          BIGSERIAL PRIMARY KEY,
    user_id     BIGINT REFERENCES users (id),
    total_price DECIMAL(10, 2)
)