package com.asasan.warehousemanagement.api.feign;

import com.asasan.warehousemanagement.api.service.WarehouseManagementServiceApi;
import com.asasan.warehousemanagement.api.dto.ItemDto;
import com.asasan.warehousemanagement.api.dto.ItemCreationDto;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
//@FeignClient(name = "${warehouse.management.service.name}/warehouse")
public interface WarehouseManagementServiceClient extends WarehouseManagementServiceApi {

    /**
     * {@inheritDoc}
     */
    @RequestLine("GET /")
    List<ItemDto> getItems();

    /**
     * {@inheritDoc}
     */
    @RequestLine("GET /{itemId}")
    ItemDto getItemById(@Param("itemId") int itemId);

    /**
     * {@inheritDoc}
     */
    @RequestLine("POST /")
    ItemDto createItem(ItemCreationDto itemCreationDto);

    /**
     * {@inheritDoc}
     */
    @RequestLine("PUT /{itemId}/amount/{amount}")
    ItemDto changeItemAmount(@Param("itemId") int itemId, @Param("amount") int amount);

}
