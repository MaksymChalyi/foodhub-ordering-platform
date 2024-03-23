package com.maksimkaxxl.foodhuborderingplatform.persistense.entity;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.abstractentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "pizzas")
public class Pizza extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

/*    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;*/

    @ManyToMany
    @JoinTable(
            name = "pizza_ingredients",
            joinColumns = @JoinColumn(name = "pizzas_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id")
    )
    private List<Ingredient> ingredients;


}
