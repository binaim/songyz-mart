package com.biniam.inventoryservice.repository;

import com.biniam.inventoryservice.dto.InventoryStatus;
import com.biniam.inventoryservice.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {

    // Find an inventory item by its SKU
    Optional<InventoryItem> findBySku(String sku);

    // Find all inventory items with a specific status
    List<InventoryItem> findByStatus(InventoryStatus status);

    // Find all inventory items for a given location
    List<InventoryItem> findByLocationId(Long locationId);

    // Find all inventory items with quantity less than a specified amount
    List<InventoryItem> findByQuantityLessThan(Integer quantity);

    // Find all inventory items with a price between a range
    List<InventoryItem> findByPriceBetween(Double minPrice, Double maxPrice);

    // Check if an item with a specific SKU exists
    boolean existsBySku(String sku);

    // Custom query to update the quantity of an item
    @Modifying
    @Query("UPDATE InventoryItem i SET i.quantity = :quantity WHERE i.sku = :sku")
    int updateQuantity(@Param("sku") String sku, @Param("quantity") Integer quantity);

    // Custom query to find items that are low in stock (you can define your own threshold)
    @Query("SELECT i FROM InventoryItem i WHERE i.quantity < :threshold")
    InventoryItem indLowStockItems(@Param("threshold") Integer threshold);
}
