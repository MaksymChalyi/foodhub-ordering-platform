package com.maksimkaxxl.foodhuborderingplatform.persistense.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PizzaOrderDTO {

    private String pizzaName;
    private List<String> ingredients;

}
