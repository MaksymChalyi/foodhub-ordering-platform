package com.maksimkaxxl.foodhuborderingplatform.controller.admin;

import com.maksimkaxxl.foodhuborderingplatform.service.PizzaService;
import com.maksimkaxxl.persistense.entity.Pizza;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/admin")
public class AdminController {


    private PizzaService pizzaService;

    @PostMapping(name = "/pizza")
    public ResponseEntity<Pizza> createNewPizza(@RequestBody Pizza pizza) {
        pizzaService.create(pizza);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
