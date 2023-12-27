package com.mizanlabs.mr.service;

import com.mizanlabs.mr.entities.Item;
import com.mizanlabs.mr.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Optional<Item> updateItem(Long id, Item itemDetails) {
        return itemRepository.findById(id).map(item -> {
            item.setItemName(itemDetails.getItemName());
            item.setItemUnit(itemDetails.getItemUnit());
            item.setItemPrice(itemDetails.getItemPrice());
            item.setItemType(itemDetails.getItemType());
            item.setItemNote(itemDetails.getItemNote());
            // Set other fields...
            return itemRepository.save(item);
        });
    }

    public boolean deleteItem(Long id) {
        boolean exists = itemRepository.existsById(id);
        if (!exists) {
            return false;
        }
        itemRepository.deleteById(id);
        return true;
    }
}
