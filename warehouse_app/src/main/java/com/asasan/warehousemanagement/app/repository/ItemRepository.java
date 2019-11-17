package com.asasan.warehousemanagement.app.repository;

import com.asasan.warehousemanagement.app.entity.Item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

}
