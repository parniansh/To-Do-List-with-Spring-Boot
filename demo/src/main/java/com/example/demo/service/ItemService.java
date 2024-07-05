package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public String addItem(Item item){
        item.setDate(new Date(System.currentTimeMillis()));
        itemRepository.save(item);
        return item.getName();
    }

    public List<Item> getItems(Integer userId) {
        return itemRepository.findByUserId(userId);
    }
}
