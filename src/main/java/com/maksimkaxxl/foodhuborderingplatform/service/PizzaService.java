package com.maksimkaxxl.foodhuborderingplatform.service;


import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;

import java.util.List;

public interface PizzaService extends BaseService<Pizza> {

    Pizza findById(Long id);
    Pizza findByName(String name);

    void create(Pizza pizza);

    List<Pizza> findAll();

    boolean delete(Long id);




}
