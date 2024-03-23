package com.maksimkaxxl.foodhuborderingplatform.controller.user;

import com.maksimkaxxl.foodhuborderingplatform.persistense.dto.PizzaOrderDTO;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Ingredient;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;
import com.maksimkaxxl.foodhuborderingplatform.persistense.mapper.PizzaMapper;
import com.maksimkaxxl.foodhuborderingplatform.service.PizzaPriceCalculator;
import com.maksimkaxxl.foodhuborderingplatform.service.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private PizzaService pizzaService;
    private PizzaPriceCalculator pizzaPriceCalculator;
    private PizzaMapper pizzaMapper;


    @PostMapping(value = "/pizza")
    public ResponseEntity<Pizza> createNewPizza(@RequestBody PizzaOrderDTO pizzaOrderDTO) {
        Pizza pizza = pizzaMapper.mapToEntity(pizzaOrderDTO);
        BigDecimal pizzaPrice = pizzaPriceCalculator.calculatePizzaPrice(pizza);
        pizza.setPrice(pizzaPrice);
        pizzaService.create(pizza);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/menu")
    public ResponseEntity<List<Pizza>> getAllIngredients() {
        List<Pizza> pizzas = pizzaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pizzas);
    }


}
