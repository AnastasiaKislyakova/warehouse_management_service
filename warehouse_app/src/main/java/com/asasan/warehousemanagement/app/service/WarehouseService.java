package com.asasan.warehousemanagement.app.service;

import com.asasan.warehousemanagement.api.dto.ItemCreationDto;
import com.asasan.warehousemanagement.api.dto.ItemDto;

import java.util.List;

public interface WarehouseService {
    List<ItemDto> getItems();

    ItemDto getItemById(int itemId);

    ItemDto createItem(ItemCreationDto itemCreationDto);

    ItemDto changeItemAmount(int id, int amount);
}
