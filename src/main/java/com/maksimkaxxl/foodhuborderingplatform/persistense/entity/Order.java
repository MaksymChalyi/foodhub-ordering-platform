package com.maksimkaxxl.foodhuborderingplatform.persistense.entity;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.abstractentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Pizza> pizzas;

    @Column(name = "total_price")
    private double totalPrice;


}
