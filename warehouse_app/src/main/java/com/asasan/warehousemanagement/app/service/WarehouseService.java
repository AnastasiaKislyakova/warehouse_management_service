package com.asasan.warehousemanagement.app.service;

import com.asasan.warehousemanagement.api.dto.ItemCreationDto;
import com.asasan.warehousemanagement.api.dto.ItemDto;

import java.util.List;

public interface WarehouseService {
    List<ItemDto> getItems();

    ItemDto getItemById(long Id);

    ItemDto createItem(ItemCreationDto itemCreationDto);

    ItemDto changeItemAmount(long id, long amount);
}
