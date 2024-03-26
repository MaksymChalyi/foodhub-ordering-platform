package com.maksimkaxxl.foodhuborderingplatform.service;


import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Order;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;

import java.util.List;

public interface OrderService extends BaseService<Order> {

    Order findById(Long id);


    void create(Order order);

//    List<Order> findAll();

    boolean delete(Long id);


}
