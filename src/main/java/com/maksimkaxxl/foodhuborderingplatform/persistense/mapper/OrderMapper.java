package com.maksimkaxxl.foodhuborderingplatform.persistense.mapper;

import com.maksimkaxxl.foodhuborderingplatform.exception.IngredientNotFoundException;
import com.maksimkaxxl.foodhuborderingplatform.persistense.dto.OrderDTO;
import com.maksimkaxxl.foodhuborderingplatform.persistense.dto.PizzaOrderDTO;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Ingredient;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Order;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;
import com.maksimkaxxl.foodhuborderingplatform.service.IngredientService;
import com.maksimkaxxl.foodhuborderingplatform.service.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class OrderMapper {

    private final PizzaService pizzaService;

    public Order mapToEntity(OrderDTO orderDTO) {
        Order order = new Order();
        BigDecimal orderPrice = BigDecimal.ZERO;

        List<Pizza> pizzas = new ArrayList<>();
        for (String pizzaName : orderDTO.getPizzas()) {
            var pizza = pizzaService.findByName(pizzaName);
            if (pizza != null) {
                pizzas.add(pizza);
                orderPrice = orderPrice.add(pizza.getPrice());

            } else {
                throw new IngredientNotFoundException("Pizza with name " + pizzaName + " not found");
            }
        }
        order.setTotalPrice(orderPrice);
        order.setPizzas(pizzas);

        return order;
    }


}
