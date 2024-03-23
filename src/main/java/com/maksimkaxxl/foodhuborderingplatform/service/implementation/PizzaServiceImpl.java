package com.maksimkaxxl.foodhuborderingplatform.service.implementation;

import com.maksimkaxxl.foodhuborderingplatform.service.PizzaService;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;
import com.maksimkaxxl.foodhuborderingplatform.persistense.repository.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PizzaServiceImpl implements PizzaService {


    private PizzaRepository pizzaRepository;

    @Override
    public Pizza findById(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        var ingredient = pizzaRepository.findById(id);
        if (ingredient.isPresent()) {
            pizzaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
