package com.example.demoJava.service;


import com.example.demoJava.Repository.ItemRepository;
import com.example.demoJava.entity.Item;
import com.example.demoJava.in.ItemIn;
import com.example.demoJava.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItemServiceImp implements ItemService{
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Map<String, Object> getAll(Pageable pageable, String textSearch) {
        Page<Item> list;
        list = itemRepository.findAllByNameContaining(pageable, textSearch);
        Map<String,Object> respon = new HashMap<>();
        respon.put("result", list.getContent());
        respon.put("totalPage",list.getTotalPages());
        return respon;
    }

    @Override
    public Item create(ItemIn itemIn) {
        Item item = ItemMapper.map(itemIn);
        return itemRepository.save(item);
    }

    @Override
    public Item update(Integer id, ItemIn itemIn) {
        Item item = itemRepository.findItemById(id);
        item.setId(id);;
        item.setName(itemIn.getName());

        return itemRepository.save(item);
    }

    @Override
    public Item getID(Integer id) {
        Item item = itemRepository.findItemById(id);
        return item;
    }

    @Override
    public Map<String, Object> delete(Integer id) {
        Item item = itemRepository.findItemById(id);
        itemRepository.delete(item);
        Map<String,Object> respon = new HashMap<>();
        respon.put("result","ok");

        return respon;
    }
}
