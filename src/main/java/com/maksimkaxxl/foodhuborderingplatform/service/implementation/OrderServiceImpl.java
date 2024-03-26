package com.maksimkaxxl.foodhuborderingplatform.service.implementation;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Order;
import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.Pizza;
import com.maksimkaxxl.foodhuborderingplatform.persistense.repository.OrderRepository;
import com.maksimkaxxl.foodhuborderingplatform.persistense.repository.PizzaRepository;
import com.maksimkaxxl.foodhuborderingplatform.service.OrderService;
import com.maksimkaxxl.foodhuborderingplatform.service.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository;


    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Order order) {
        orderRepository.save(order);
    }

    @Override
    public boolean delete(Long id) {
        var ingredient = orderRepository.findById(id);
        if (ingredient.isPresent()) {
            orderRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
