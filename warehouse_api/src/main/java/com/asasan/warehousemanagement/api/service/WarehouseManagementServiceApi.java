package com.asasan.warehousemanagement.api.service;

import com.asasan.warehousemanagement.api.dto.ItemCreationDto;
import com.asasan.warehousemanagement.api.dto.ItemDto;

import java.util.List;

/**
 * Interface for accessing user service
 */
public interface WarehouseManagementServiceApi {

    /**
     * Returns all items
     */
    List<ItemDto> getItems();

    /**
     * Returns item by id
     */
    ItemDto getItemById(long Id);

    /**
     * Returns created item with its id
     */
    ItemDto createItem(ItemCreationDto itemCreationDto);

    /**
     * Changes amount of item by id
     */
    ItemDto changeItemAmount(long id, long amount);

}
