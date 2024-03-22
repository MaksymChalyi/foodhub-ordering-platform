package com.maksimkaxxl.foodhuborderingplatform.controller.admin;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Ingredient;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;
import com.maksimkaxxl.foodhuborderingplatform.service.IngredientService;
import com.maksimkaxxl.foodhuborderingplatform.service.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ingredients);
    }

    @GetMapping(value = "/ingredient/{ingredientId}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long ingredientId) {
        var ingredient = ingredientService.findById(ingredientId);
        return ResponseEntity.status(HttpStatus.OK).body(ingredient);
    }

    @PostMapping(value = "/ingredient")
    public ResponseEntity<Ingredient> createNewIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.create(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/ingredient/{ingredientId}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long ingredientId, @RequestBody Ingredient updatedIngredient) {
        Optional<Ingredient> existingIngredientOptional = Optional.ofNullable(ingredientService.findById(ingredientId));
        if (existingIngredientOptional.isPresent()) {
            Ingredient existingIngredient = existingIngredientOptional.get();
            existingIngredient.setName(updatedIngredient.getName());
            existingIngredient.setDescription(updatedIngredient.getDescription());
            existingIngredient.setPrice(updatedIngredient.getPrice());

            ingredientService.update(existingIngredient);
            return ResponseEntity.ok(existingIngredient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/ingredient/{ingredientId}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long ingredientId) {
        boolean deleted = ingredientService.delete(ingredientId);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/pizza/{pizzaId}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long pizzaId) {
        boolean deleted = pizzaService.delete(pizzaId);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
