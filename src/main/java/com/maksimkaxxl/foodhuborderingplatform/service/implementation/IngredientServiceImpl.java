package com.maksimkaxxl.foodhuborderingplatform.service.implementation;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Ingredient;
import com.maksimkaxxl.foodhuborderingplatform.persistense.repository.IngredientRepository;
import com.maksimkaxxl.foodhuborderingplatform.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;


    @Override
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        var ingredient = ingredientRepository.findById(id);
        if (ingredient.isPresent()) {
            ingredientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void update(Ingredient existingIngredient) {
        this.create(existingIngredient);
    }
}
