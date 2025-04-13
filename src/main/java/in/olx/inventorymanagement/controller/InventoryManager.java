package in.olx.inventorymanagement.controller;

import in.olx.inventorymanagement.model.dto.ResponseDTO.InventoryDTO;
import in.olx.inventorymanagement.model.dto.requestDTO.CreateInventoryRequest;
import in.olx.inventorymanagement.service.InventoryManagingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//import in.olx.inventorymanagement.service.InventoryService;
//import org.springframework.data.domain.Page;

@RestController
@RequestMapping ("/")
public class InventoryManager {

<<<<<<< Updated upstream
    private final InventoryService inventoryService;
    private final InventoryManagingService inventoryManagingService;
=======
    @Autowired
    private final InventoryManagingService inventoryManagingService;
//    private final InventoryService inventoryService;
>>>>>>> Stashed changes


    InventoryManager (InventoryManagingService inventoryManagingService) {
        this.inventoryManagingService = inventoryManagingService;
//        this.inventoryService = null;
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
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
    @GetMapping("/{sku}")
    public InventoryDTO getInventoryById(@PathVariable String sku) {
        return inventoryManagingService.getInventoryBySKU(sku);
    }
=======
>>>>>>> Stashed changes

//    @GetMapping("/{sku}")
//    public InventoryDTO getInventoryById(@PathVariable String sku) {
//        return null;
//    }
//
//
//    @PutMapping("/{sku}")
//    public InventoryDTO updateInventory(@PathVariable String sku, @RequestBody InventoryDTO inventoryDTO) { return null; }

<<<<<<< Updated upstream
    //pagination begins

    @Autowired
    public InventoryManager(InventoryService inventoryService, InventoryManagingService inventoryManagingService) {
        this.inventoryManagingService = inventoryManagingService;
        this.inventoryService = inventoryService;  // Spring will inject the InventoryService
    }

    @GetMapping("/pagination")
    public Page<in.olx.inventorymanagement.model.dto.InventoryDTO> getAllInventoriesWithPagination(@RequestParam(defaultValue = "0") int page) {
        return inventoryService.getAllInventoriesWithPagination(page);
    }

=======

//    @GetMapping("/pagination")
//    public Page<InventoryDTO> getAllInventoriesWithPagination(@RequestParam(defaultValue = "0") int page) {
//        assert inventoryService != null;
//        return inventoryService.getAllInventoriesWithPagination(page);
//    }
>>>>>>> Stashed changes
}
