package com.maksimkaxxl.foodhuborderingplatform.controller.user;

import com.maksimkaxxl.foodhuborderingplatform.persistense.dto.PizzaOrderDTO;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Ingredient;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;
import com.maksimkaxxl.foodhuborderingplatform.service.IngredientService;
import com.maksimkaxxl.foodhuborderingplatform.service.PizzaPriceCalculator;
import com.maksimkaxxl.foodhuborderingplatform.service.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private PizzaService pizzaService;
    private PizzaPriceCalculator pizzaPriceCalculator;
    private IngredientService ingredientService;


    @PostMapping(value = "/pizza")
    public ResponseEntity<Pizza> createNewPizza(@RequestBody PizzaOrderDTO pizzaOrderDTO) {
        String pizzaName = pizzaOrderDTO.getPizzaName();
        List<String> ingredientNames = pizzaOrderDTO.getIngredients();

        List<Ingredient> ingredients = new ArrayList<>();
        for (var ingredientName : ingredientNames) {
            Ingredient existingIngredient = ingredientService.findByName(ingredientName);
            if (existingIngredient != null) {
                ingredients.add(existingIngredient);
            } else {
                // TODO: Refactor this adn add finctional for else
                // Обробка випадку, коли інгредієнт не знайдено за вказаною назвою
                // Наприклад, можна викинути виняток або повернути користувачеві повідомлення про помилку
            }
        }

        Pizza newPizza = new Pizza();
        newPizza.setName(pizzaName);
        newPizza.setIngredients(ingredients);

        BigDecimal pizzaPrice = pizzaPriceCalculator.calculatePizzaPrice(newPizza);
        newPizza.setPrice(pizzaPrice);

        pizzaService.create(newPizza);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}
