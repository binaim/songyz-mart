package com.biniam.inventoryservice.service;

import com.biniam.inventoryservice.model.InventoryItem;
import com.biniam.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class InventoryServiceTest {
    @InjectMocks
    private InventoryService inventoryService;
    @Mock
    private InventoryRepository inventoryRepository;

    @BeforeEach
    void setUp() {

//        MockitoAnnotations.openMocks(this);

    }

    @Test
    void getInventoryItemBySKU_whenItExists() {

        String skuCode = "iphone_13_black";
        InventoryItem expectedItem = new InventoryItem();
        expectedItem.setSku(skuCode);
        when(inventoryRepository.findBySku(skuCode)).thenReturn(Optional.of(expectedItem));
        InventoryItem result = inventoryService.getInventoryItemBySKU(skuCode);

        assertNotNull(result);
        assertEquals(skuCode, result.getSku());
        verify(inventoryRepository).findBySku(skuCode);
    }

    @Test
    void getInventoryItemBySKU_whenItDoesNotExist(){

        String skuCode = "iphone_13_black";
        when(inventoryRepository.findBySku(skuCode)).thenReturn(Optional.empty());
        InventoryItem result = inventoryService.getInventoryItemBySKU(skuCode);
        assertNull(result.getSku());
        assertNotNull(result);
        verify(inventoryRepository).findBySku(skuCode);

    }
    @Test
    void createInventoryItem() {

        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setSku("iphone_13_gray");
        when(inventoryRepository.save(inventoryItem)).thenReturn(inventoryItem);
        InventoryItem result = inventoryService.createInventoryItem(inventoryItem);
        assertNotNull(result);
        assertEquals(inventoryItem.getSku(), result.getSku());
        verify(inventoryRepository).save(inventoryItem);

    }

    @Test
    void getAllInventoryItems() {

        when(inventoryRepository.findAll()).thenReturn(List.of(new InventoryItem(), new InventoryItem()));
        List<InventoryItem> result = inventoryService.getAllInventoryItems();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(inventoryRepository).findAll();

    }
}