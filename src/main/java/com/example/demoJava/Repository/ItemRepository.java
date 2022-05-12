package com.example.demoJava.Repository;

import com.example.demoJava.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    Item findItemById(Integer id);

    Page<Item> findAllByNameContaining(Pageable pageable, String textSearch);
}
