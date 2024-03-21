package com.maksimkaxxl.foodhuborderingplatform.service;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Ingredient;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;

import java.util.List;

public interface IngredientService extends BaseService<Ingredient> {

    Ingredient findById(Long id);

    void create(Ingredient ingredient);

    List<Ingredient> findAll();

    boolean delete(Long id);


    void update(Ingredient existingIngredient);
}

