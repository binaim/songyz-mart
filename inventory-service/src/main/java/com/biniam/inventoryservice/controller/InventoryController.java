package com.biniam.inventoryservice.controller;

import com.biniam.inventoryservice.model.InventoryItem;
import com.biniam.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1.0/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping()
    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
        return ResponseEntity.ok(inventoryService.getAllInventoryItems());
    }


    @GetMapping("/{sku}")
    public InventoryItem getInventoryItem(String sku) {
        return inventoryService.getInventoryItem(sku);
    }


    @PostMapping()
    public InventoryItem createInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryService.createInventoryItem(inventoryItem);
    }
}
