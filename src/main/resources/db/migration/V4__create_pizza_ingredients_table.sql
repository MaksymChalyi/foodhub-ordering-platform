CREATE TABLE pizza_ingredients
(
    pizzas_id      BIGINT REFERENCES pizzas(id),
    ingredients_id BIGINT REFERENCES ingredients(id),
    PRIMARY KEY (pizzas_id, ingredients_id)

)