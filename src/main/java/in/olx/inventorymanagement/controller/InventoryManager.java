package in.olx.inventorymanagement.controller;

import in.olx.inventorymanagement.model.dto.CarInventoryDTO;
import in.olx.inventorymanagement.model.dto.ResponseDTO.InventoryDTO;
import in.olx.inventorymanagement.model.dto.requestDTO.CreateInventoryRequest;
import in.olx.inventorymanagement.model.dto.requestDTO.UpdateInventoryRequest;
import in.olx.inventorymanagement.service.InventoryManagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import in.olx.inventorymanagement.service.InventoryService;
import org.springframework.data.domain.Page;

@RestController
public class InventoryManager {

    private final InventoryService inventoryService;
    private final InventoryManagingService inventoryManagingService;

    @Autowired
    public InventoryManager (InventoryService inventoryService, InventoryManagingService inventoryManagingService) {
        this.inventoryManagingService = inventoryManagingService;
        this.inventoryService = inventoryService;
    }

    @GetMapping ("/health")
    public String health() {
        return "Hello World!!";
    }

    @PostMapping
    public ResponseEntity<Object> createInventory(@RequestBody CreateInventoryRequest requestDTO) {
        try {
            InventoryDTO inventory = inventoryManagingService.createInventory(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(inventory);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Exception("Internal Server Error"));
        }
    }

    @GetMapping("/{sku}")
    public InventoryDTO getInventoryById(@PathVariable String sku) {
        if(sku == null || sku.isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be null or empty");
        }
        return inventoryManagingService.getInventoryBySKU(sku);
    }

    @PatchMapping("/{sku}")
    public InventoryDTO updateInventory(@PathVariable String sku, @RequestBody UpdateInventoryRequest inventoryDTO) {
        // Set the sku in the requestDTO before passing it to the service (since it's in the URL)
        inventoryDTO.setSku(sku);

        // Call the service method to update the inventory and/or car
        return inventoryManagingService.patchInventoryAndCar(inventoryDTO);
    }

    @GetMapping
    public Page<CarInventoryDTO> getAllInventoriesWithPagination(@RequestParam(defaultValue = "0") int page) {
        return inventoryService.getAllInventoriesWithPagination(page);
    }
}
