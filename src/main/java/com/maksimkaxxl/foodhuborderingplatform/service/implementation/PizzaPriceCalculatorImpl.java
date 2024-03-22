package com.maksimkaxxl.foodhuborderingplatform.service.implementation;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;
import com.maksimkaxxl.foodhuborderingplatform.service.PizzaPriceCalculator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PizzaPriceCalculatorImpl implements PizzaPriceCalculator {

    public BigDecimal calculatePizzaPrice(Pizza pizza) {
        var price = BigDecimal.ZERO;
        for (var priceOfIngredient : pizza.getIngredients()) {
            var ingredientPrice = priceOfIngredient.getPrice();
            price = price.add(ingredientPrice);
        }

        return price;
    }
}
