package com.maksimkaxxl.foodhuborderingplatform.persistense.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {

    private List<String> pizzas;

}
