package com.example.demoJava.controller;


import com.example.demoJava.entity.Item;
import com.example.demoJava.in.ItemIn;
import com.example.demoJava.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Map;

@RestController
@RequestMapping("/Item")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/Get", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(@PageableDefault(size = 4) Pageable pageable, @RequestParam(defaultValue = "") String textSearch){
        return new ResponseEntity<Map<String,Object>>(itemService.getAll(pageable, textSearch), HttpStatus.OK);
    }

    @RequestMapping(value = "/GetById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getId(@PathVariable Integer id) {
        return new ResponseEntity<Item>(itemService.getID(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/Add", method = RequestMethod.POST)
    public ResponseEntity<?>create(@RequestBody ItemIn itemIn){
        return new ResponseEntity<Item>(itemService.create(itemIn), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/Update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?>update(@PathVariable Integer id,@RequestBody ItemIn itemIn){
        return new ResponseEntity<Item>(itemService.update(id,itemIn), HttpStatus.OK);
    }

    @RequestMapping(value = "/Delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?>delete(@PathVariable Integer id){
        return new ResponseEntity<Map<String, Object>>(itemService.delete(id), HttpStatus.OK);
    }
}
