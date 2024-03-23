package com.maksimkaxxl.foodhuborderingplatform.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(String message) {
        super(message);
    }
}
