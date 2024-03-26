package com.maksimkaxxl.foodhuborderingplatform.persistense.entity;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.abstractentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {

/*    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;*/

    @ManyToMany
    @JoinTable(
            name = "order_pizzas",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private List<Pizza> pizzas;

    @Column(name = "total_price")
    private BigDecimal totalPrice;


}
