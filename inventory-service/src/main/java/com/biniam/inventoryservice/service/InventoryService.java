package com.biniam.inventoryservice.service;

import com.biniam.inventoryservice.model.InventoryItem;
import com.biniam.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryItem getInventoryItemBySKU(String sku) {

        Optional<InventoryItem> item = inventoryRepository.findBySku(sku);

        if(item.isPresent()){
            return item.get();
        }else{
            return item.orElseGet(InventoryItem::new);
        }
    }

    public InventoryItem createInventoryItem(InventoryItem inventoryItem) {

        return inventoryRepository.save(inventoryItem);
    }

    public List<InventoryItem> getAllInventoryItems() {

        return inventoryRepository.findAll();
    }

    // Use the repository methods here
}
