package in.olx.inventorymanagement.controller;

import in.olx.inventorymanagement.service.InventoryManagingService;
import in.olx.inventorymanagement.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class InventoryManagerTest {
    InventoryManager inventoryManager;
    InventoryService inventoryService;
    InventoryManagingService inventoryManagingService;

    @BeforeEach
    void setUp() {
        inventoryManagingService = mock(InventoryManagingService.class);
        inventoryService = mock(InventoryService.class);
        inventoryManager = new InventoryManager(inventoryService, inventoryManagingService);
    }

    @Test
    void testHealth() {
        assertEquals("Hello World!!", inventoryManager.health());
    }

    @Test
    void testCreateInventory() {

    }
}
