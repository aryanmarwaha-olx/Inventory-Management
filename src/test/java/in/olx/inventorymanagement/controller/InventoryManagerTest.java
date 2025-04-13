<<<<<<< Updated upstream
//package in.olx.inventorymanagement.controller;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class InventoryManagerTest {
//    InventoryManager inventoryManager;
//    @BeforeEach
//    void setUp() {
//        inventoryManager = new InventoryManager();
//    }
//
//    @Test
//    void testHealth() {
//        assertEquals("Hello World!!", inventoryManager.health());
//    }
//}
=======
package in.olx.inventorymanagement.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    InventoryManager inventoryManager;
    @BeforeEach
    void setUp() {
//        inventoryManager = new InventoryManager();
    }

    @Test
    void testHealth() {
        assertEquals("Hello World!!", inventoryManager.health());
    }
}
>>>>>>> Stashed changes
