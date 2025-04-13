package in.olx.inventorymanagement.controller;

import in.olx.inventorymanagement.model.dto.ResponseDTO.InventoryDTO;
import in.olx.inventorymanagement.model.dto.requestDTO.CreateInventoryRequest;
import in.olx.inventorymanagement.service.InventoryManagingService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import in.olx.inventorymanagement.service.InventoryService;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping ("/")
public class InventoryManager {

    private final InventoryManagingService inventoryManagingService;
    private final InventoryService inventoryService;

    InventoryManager (InventoryManagingService inventoryManagingService) {
        this.inventoryManagingService = inventoryManagingService;
        this.inventoryService = null;
    }

    @GetMapping ("/health")
    public String health() {
        return "Hello World!!";
    }

    // Rest All Routes are to be added below:
//    @GetMapping
//    public InventoryDTO getAllInventories() {
//        return null;
//    }

    @PostMapping
    public ResponseEntity<Object> createInventory(@RequestBody CreateInventoryRequest requestDTO) {
        try {
            InventoryDTO inventory = inventoryManagingService.createInventory(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(inventory);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Exception("Internal Server Error"));
        }
    }

    @GetMapping("/{sku}")
    public InventoryDTO getInventoryById(@PathVariable String sku) {
        return inventoryManagingService.getInventoryBySKU(sku);
    }

    @PutMapping("/{sku}")
    public InventoryDTO updateInventory(@PathVariable String sku, @RequestBody InventoryDTO inventoryDTO) { return null; }

    @GetMapping("/")
    public Page<InventoryDTO> getAllInventoriesWithPagination(@RequestParam(defaultValue = "0") int page) {
        assert inventoryService != null;
        return  inventoryService.getAllInventoriesWithPagination(page);
    }
}
