package com.asasan.warehousemanagement.app.service.impl;

import com.asasan.warehousemanagement.api.dto.ItemCreationDto;
import com.asasan.warehousemanagement.api.dto.ItemDto;
import com.asasan.warehousemanagement.app.entity.Item;
import com.asasan.warehousemanagement.app.repository.ItemRepository;
import com.asasan.warehousemanagement.app.service.WarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private static final Logger logger = LoggerFactory.getLogger(WarehouseServiceImpl.class);

    private ItemRepository itemRepository;

    @Autowired
    public WarehouseServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemDto> getItems() {
        return null;
    }

    @Override
    public ItemDto getItemById(long Id) {
        return null;
    }

    @Override
    public ItemDto createItem(ItemCreationDto itemCreationDto) {
        Item item = new Item(itemCreationDto);
        itemRepository.save(item);
        return item.toItemDto();
    }

    @Override
    public ItemDto changeItemAmount(long id, long amount) {
        return null;
    }
}
