package com.asasan.warehousemanagement.app.controller;

import com.asasan.warehousemanagement.api.dto.ItemCreationDto;
import com.asasan.warehousemanagement.api.dto.ItemDto;
import com.asasan.warehousemanagement.app.service.WarehouseService;
import com.asasan.warehousemanagement.app.service.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("warehouse")
public class WarehouseController {
    private WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    ItemDto createItem(@RequestBody ItemCreationDto itemCreationDto) {
        return warehouseService.createItem(itemCreationDto);
    }

    @GetMapping(value = "{itemId}")
    ItemDto getItemById(@PathVariable Integer itemId) {
        return warehouseService.getItemById(itemId);
    }

    @GetMapping
    List<ItemDto> getItems() {
        return warehouseService.getItems();
    }

    @PutMapping(value = "{itemId}/amount/{amount}")
    ItemDto changeItemAmount(@PathVariable Integer itemId, @PathVariable Integer amount) {
        return warehouseService.changeItemAmount(itemId, amount);
    }

}