package com.asasan.warehousemanagement.app.service.impl;

import com.asasan.warehousemanagement.api.dto.ItemCreationDto;
import com.asasan.warehousemanagement.api.dto.ItemDto;
import com.asasan.warehousemanagement.app.entity.Item;
import com.asasan.warehousemanagement.app.repository.ItemRepository;
import com.asasan.warehousemanagement.app.service.WarehouseService;
import com.asasan.warehousemanagement.app.stream.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return Streams
                .of(itemRepository.findAll())
                .map(Item::toItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto getItemById(int itemId) {
        logger.info("Looking for an item by id {}", itemId);
        Item foundItem = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("There is no such order in database"));
        return foundItem.toItemDto();
    }

    @Override
    public ItemDto createItem(ItemCreationDto itemCreationDto) {
        Item item = new Item(itemCreationDto);
        itemRepository.save(item);
        return item.toItemDto();
    }

    @Override
    public ItemDto changeItemAmount(int id, int amount) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("There is no such order in database"));
        item.setAmount(item.getAmount() + amount);
        itemRepository.save(item);
        return item.toItemDto();
    }
}
