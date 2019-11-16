package com.asasan.warehousemanagement.api.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ItemDto {

    private int id;
    private String name;
    private int amount;
    private long price;
}