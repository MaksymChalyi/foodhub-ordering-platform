package com.maksimkaxxl.foodhuborderingplatform.entity;

import com.maksimkaxxl.foodhuborderingplatform.entity.abstractentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "pizzas")
public class Pizza extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToMany
    @JoinTable(
            name = "pizza_ingredients",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;


}
