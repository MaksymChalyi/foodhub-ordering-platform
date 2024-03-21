package com.maksimkaxxl.foodhuborderingplatform.service;

import com.maksimkaxxl.foodhuborderingplatform.persistense.entity.abstractentity.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity> {

    List<E> findAll();

    E findById(Long id);


}
