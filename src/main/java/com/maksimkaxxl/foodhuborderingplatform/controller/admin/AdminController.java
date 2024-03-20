package com.maksimkaxxl.foodhuborderingplatform.controller.admin;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Ingredient;
import com.maksimkaxxl.foodhuborderingplatform.service.IngredientService;
import com.maksimkaxxl.foodhuborderingplatform.service.PizzaService;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/admin")
public class AdminController {

    private PizzaService pizzaService;
    private IngredientService ingredientService;

    @PostMapping(value = "/pizza")
    public ResponseEntity<Pizza> createNewPizza(@RequestBody Pizza pizza) { // TODO: refactor this method and complete them
        pizzaService.create(pizza);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/ingredient")
    public ResponseEntity<Ingredient> createNewIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.create(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ingredients);
    }


}
