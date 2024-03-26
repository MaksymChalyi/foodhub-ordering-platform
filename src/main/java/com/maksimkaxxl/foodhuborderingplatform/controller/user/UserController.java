package com.maksimkaxxl.foodhuborderingplatform.controller.user;

import com.maksimkaxxl.foodhuborderingplatform.persistense.dto.OrderDTO;
import com.maksimkaxxl.foodhuborderingplatform.persistense.dto.PizzaOrderDTO;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Ingredient;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Order;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;
import com.maksimkaxxl.foodhuborderingplatform.persistense.mapper.OrderMapper;
import com.maksimkaxxl.foodhuborderingplatform.persistense.mapper.PizzaMapper;
import com.maksimkaxxl.foodhuborderingplatform.service.OrderService;
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
    private OrderService orderService;
    private PizzaPriceCalculator pizzaPriceCalculator;
    private PizzaMapper pizzaMapper;
    private OrderMapper orderMapper;


    @PostMapping(value = "/pizza")
    public ResponseEntity<Pizza> createNewPizza(@RequestBody PizzaOrderDTO pizzaOrderDTO) {
        Pizza pizza = pizzaMapper.mapToEntity(pizzaOrderDTO);
        BigDecimal pizzaPrice = pizzaPriceCalculator.calculatePizzaPrice(pizza);
        pizza.setPrice(pizzaPrice);
        pizzaService.create(pizza);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/menu")
    public ResponseEntity<List<Pizza>> getAllPizzas() {
        List<Pizza> pizzas = pizzaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pizzas);
    }

    @PostMapping(value = "/order")
    public ResponseEntity<Order> makeOrder(@RequestBody OrderDTO orderDTO) {
        var order = orderMapper.mapToEntity(orderDTO);
        orderService.create(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping(value = "/order/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(orderId));
    }

    @DeleteMapping(value = "/order/{orderId}")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long orderId) {
        boolean deleted = orderService.delete(orderId);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
