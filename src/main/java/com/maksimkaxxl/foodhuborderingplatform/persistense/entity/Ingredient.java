package com.maksimkaxxl.foodhuborderingplatform.persistense.entity;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.abstractentity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "ingredients")
public class Ingredient extends BaseEntity {

    @Column(name = "photo_url")
    private String photo_url;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;
}
