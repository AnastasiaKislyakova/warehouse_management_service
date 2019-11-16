package com.asasan.warehousemanagement.app.controller;

import com.asasan.warehousemanagement.api.dto.ItemCreationDto;
import com.asasan.warehousemanagement.api.dto.ItemDto;
import com.asasan.warehousemanagement.app.service.WarehouseService;
import com.asasan.warehousemanagement.app.service.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

}