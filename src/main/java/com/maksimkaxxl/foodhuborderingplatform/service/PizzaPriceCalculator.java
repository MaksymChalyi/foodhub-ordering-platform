package com.maksimkaxxl.foodhuborderingplatform.service;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;

import java.math.BigDecimal;

public interface PizzaPriceCalculator {
    BigDecimal calculatePizzaPrice(Pizza pizza);
}
