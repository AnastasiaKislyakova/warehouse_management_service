package com.asasan.warehousemanagement.api.feign;

import com.asasan.warehousemanagement.api.service.WarehouseManagementServiceApi;
import com.asasan.warehousemanagement.api.dto.ItemDto;
import com.asasan.warehousemanagement.api.dto.ItemCreationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * Defines the parameters and paths of REST API of user management api
 * <p>
 * Java feign client will be generated based on this declaration.
 * <p>
 * We use placeholder in the {@link FeignClient#name()} field in order
 * for Ribbon load balancing client and Eureka discovery service to understand
 * the name of the service the request should be redirected to.
 */
@FeignClient(name = "${warehouse.management.service.name}/warehouse")
public interface WarehouseManagementServiceClient extends WarehouseManagementServiceApi {

    /**
     * {@inheritDoc}
     */
    @GetMapping
    List<ItemDto> getItems();

    /**
     * {@inheritDoc}
     */
    @GetMapping(value="{id}")
    ItemDto getItemById(long Id);

    /**
     * {@inheritDoc}
     */
    @PostMapping
    ItemDto createItem(ItemCreationDto itemCreationDto);

    /**
     * {@inheritDoc}
     */
    @PutMapping(value="items/{id}/addition/{amount}")
    ItemDto changeItemAmount(long id, long amount);

}
