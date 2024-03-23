package com.maksimkaxxl.foodhuborderingplatform.persistense.mapper;

import com.maksimkaxxl.foodhuborderingplatform.exception.IngredientNotFoundException;
import com.maksimkaxxl.foodhuborderingplatform.persistense.dto.PizzaOrderDTO;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Ingredient;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;
import com.maksimkaxxl.foodhuborderingplatform.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PizzaMapper {

    private final IngredientService ingredientService;

    @Autowired
    public PizzaMapper(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    public Pizza mapToEntity(PizzaOrderDTO pizzaOrderDTO) {
        Pizza pizza = new Pizza();
        pizza.setName(pizzaOrderDTO.getPizzaName());

        List<Ingredient> ingredients = new ArrayList<>();
        for (String ingredientName : pizzaOrderDTO.getIngredients()) {
            Ingredient ingredient = ingredientService.findByName(ingredientName);
            if (ingredient != null) {
                ingredients.add(ingredient);
            } else {
                throw new IngredientNotFoundException("Ingredient with name " + ingredientName + " not found");
            }
        }
        pizza.setIngredients(ingredients);
        return pizza;
    }


}
