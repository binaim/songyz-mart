package com.biniam.inventoryservice;

import com.biniam.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class InventoryServiceApplicationTests {

    private InventoryRepository inventoryRepository;

    @Test
    void contextLoads() {
    }

}
