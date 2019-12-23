package com.asasan.warehousemanagement.app.controller;

import com.asasan.warehousemanagement.api.dto.ItemCreationDto;
import com.asasan.warehousemanagement.api.dto.ItemDto;
import com.asasan.warehousemanagement.app.service.WarehouseService;
import com.asasan.warehousemanagement.app.service.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/warehouse")
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
    ResponseEntity<ItemDto> getItemById(@PathVariable Integer itemId) {
        ItemDto itemById = warehouseService.getItemById(itemId);
        if (itemById == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itemById);

    }

    @GetMapping
    List<ItemDto> getItems() {
        return warehouseService.getItems();
    }

    @PutMapping(value = "{itemId}/amount/{amount}")
    ResponseEntity<ItemDto> changeItemAmount(@PathVariable Integer itemId, @PathVariable Integer amount) {
        ItemDto item = warehouseService.changeItemAmount(itemId, amount);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }

}