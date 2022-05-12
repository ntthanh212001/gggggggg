package com.example.demoJava.service;

import com.example.demoJava.entity.Item;
import com.example.demoJava.in.ItemIn;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Map;

@Service
public interface ItemService {
    Map<String, Object> getAll(Pageable pageable, String textSearch);
    Item create(ItemIn itemIn);
    Item update(Integer id, ItemIn itemIn);
    Item getID(Integer id);
    Map<String, Object>delete(Integer id);
}
