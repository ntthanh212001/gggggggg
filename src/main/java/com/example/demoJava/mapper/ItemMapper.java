package com.example.demoJava.mapper;


import com.example.demoJava.dto.ItemDto;
import com.example.demoJava.entity.Item;
import com.example.demoJava.in.ItemIn;

public class ItemMapper {
    public static Item map(ItemIn itemIn){
        Item item = new Item();
        item.setName(itemIn.getName());
        return item;
    }

    public static ItemDto map(Item item){
        ItemDto itemDto = new ItemDto();
        itemDto.setName(item.getName());
        itemDto.setId(item.getId());
        return  itemDto;
    }
}
