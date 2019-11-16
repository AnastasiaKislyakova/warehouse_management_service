package com.asasan.warehousemanagement.app.entity;

import com.asasan.warehousemanagement.api.dto.ItemCreationDto;
import com.asasan.warehousemanagement.api.dto.ItemDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int amount;

    private long price;

    public Item(ItemCreationDto itemCreationDto){
        Objects.requireNonNull(itemCreationDto);
        this.name = itemCreationDto.getName();
        this.amount = itemCreationDto.getAmount();
        this.price = itemCreationDto.getPrice();
    }

    public ItemDto toItemDto(){
        ItemDto itemDto2 = new ItemDto();
        itemDto2.setId(id);
        itemDto2.setName(name);
        itemDto2.setAmount(amount);
        itemDto2.setPrice(price);
        return itemDto2;
    }
}
