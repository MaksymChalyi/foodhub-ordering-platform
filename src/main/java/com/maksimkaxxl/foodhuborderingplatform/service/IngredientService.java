package com.maksimkaxxl.foodhuborderingplatform.service;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Ingredient;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientService extends BaseService<Ingredient> {

    Ingredient findById(Long id);

    Ingredient findByName(String name);

    void create(Ingredient ingredient);

    List<Ingredient> findAll();

    boolean delete(Long id);


    void update(Ingredient existingIngredient);


}

