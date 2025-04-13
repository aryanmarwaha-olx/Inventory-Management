package in.olx.inventorymanagement.service;


import in.olx.inventorymanagement.model.dto.ResponseDTO.InventoryDTO;
import in.olx.inventorymanagement.model.dto.requestDTO.CreateInventoryRequest;

import in.olx.inventorymanagement.model.dto.requestDTO.UpdateInventoryRequest;
import in.olx.inventorymanagement.model.entity.InventoryEntity;
import in.olx.inventorymanagement.model.entity.product.CarEntity;

import in.olx.inventorymanagement.repository.InventoryRepository;
import in.olx.inventorymanagement.repository.product.CarRepository;

import in.olx.inventorymanagement.utill.Utils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
@Component
public class InventoryManagingService {

    private final InventoryRepository inventoryRepository;
    private final CarRepository carRepository;

    private final Utils util;

    InventoryManagingService(InventoryRepository inventoryRepository,  CarRepository carRepository, Utils util) {
        this.inventoryRepository = inventoryRepository;
        this.carRepository = carRepository;
        this.util = util;
    }

    private InventoryDTO convertToDTO(InventoryEntity inventory, HashMap<String, String> productMap) {
        return new InventoryDTO(
                inventory.skuId,
                inventory.primaryStatus,
                inventory.primaryLocation,
                inventory.updateDate,
                inventory.middleMan,
                inventory.dealer,
                inventory.costToCompany,
                inventory.createDate,
                inventory.productType,
                productMap
        );
    }

    public InventoryDTO patchInventoryAndCar(UpdateInventoryRequest requestDTO) {
        InventoryEntity inventory = null;

        // 1. Update Inventory if sku is present
        if (requestDTO.sku != null) {
            Optional<InventoryEntity> inventoryOpt = inventoryRepository.findById(requestDTO.sku);
            if (inventoryOpt.isEmpty()) {
                throw new EntityNotFoundException("Inventory with SKU: " + requestDTO.sku + " not found");
            }
            inventory = inventoryOpt.get();

            if (requestDTO.productId != null) {
                if (!carRepository.existsById(requestDTO.productId)) {
                    throw new IllegalArgumentException("Invalid productId: No car with VIN " + requestDTO.productId);
                }
                inventory.productId = requestDTO.productId;
            }

            if (requestDTO.primaryStatus != null) inventory.primaryStatus = requestDTO.primaryStatus;
            if (requestDTO.productType != null) inventory.productType = requestDTO.productType;
            if (requestDTO.costToCompany != null) inventory.costToCompany = requestDTO.costToCompany;
            if (requestDTO.primaryLocation != null) inventory.primaryLocation = requestDTO.primaryLocation;
            if (requestDTO.updateDate != null) inventory.updateDate = requestDTO.updateDate;
            if (requestDTO.createDate != null) inventory.createDate = requestDTO.createDate;
            if (requestDTO.dealer != null) inventory.dealer = requestDTO.dealer;
            if (requestDTO.middleMan != null) inventory.middleMan = requestDTO.middleMan;
            if (requestDTO.type != null) inventory.productType = requestDTO.type;

            inventoryRepository.save(inventory);
        }

        // 2. Update Car if productId (vin) is present
        if (requestDTO.productId != null) {
            Optional<CarEntity> carOpt = carRepository.findById(requestDTO.productId);
            if (carOpt.isEmpty()) {
                throw new EntityNotFoundException("Car with VIN: " + requestDTO.productId + " not found");
            }

            CarEntity car = carOpt.get();
            HashMap<String, String> updates = requestDTO.getProduct();

            if (updates != null) {
                if (updates.containsKey("make")) car.make = updates.get("make");
                if (updates.containsKey("model")) car.model = updates.get("model");
                if (updates.containsKey("trim")) car.trim = updates.get("trim");
                if (updates.containsKey("color")) car.color = updates.get("color");
                if (updates.containsKey("dateOfManufacture")) car.dateOfManufacture = updates.get("dateOfManufacture");
                carRepository.save(car);
            }
        }

        // 3. Prepare response DTO (only if inventory is found)
        if (inventory != null) {
            HashMap<String, String> productMap = new HashMap<>();
            if (inventory.productId != null) {
                Optional<CarEntity> carOpt = carRepository.findById(inventory.productId);
                carOpt.ifPresent(car -> {
                    productMap.put("make", car.make);
                    productMap.put("model", car.model);
                    productMap.put("trim", car.trim);
                    productMap.put("color", car.color);
                    productMap.put("dateOfManufacture", car.dateOfManufacture);
                });
            }

            return convertToDTO(inventory, productMap);
        }

        // 4. If inventory wasn't updated but car was, you can return a minimal DTO or null
        return null; // or throw an exception if both were missing
    }


    public InventoryDTO createInventory(CreateInventoryRequest requestDTO) {
        HashMap<String, String> productMap = requestDTO.getProduct();

        // code clean up required.

        CarEntity car = new CarEntity();
        CarEntity savedCar = new CarEntity();
        String productType;

        if (requestDTO.type.equals("car")) {
            car = new CarEntity(
                    productMap.get("make"),
                    productMap.get("model"),
                    productMap.get("trim"),
                    productMap.get("color"),
                    productMap.get("dateOfManufacture")
            );
            savedCar = carRepository.save(car);
            productType = "car";
        } else {
            productType = "car";
        }

        InventoryEntity inventoryEntity = new InventoryEntity(
                savedCar.vehicleIdentificationNumber,
                "created",
                "car",
                requestDTO.getCostToCompany(),
                requestDTO.getPrimaryLocation(),
                LocalDate.now().toString(),
                LocalDate.now().toString(),
                requestDTO.getDealer(),
                requestDTO.getMiddleMan()
        );

        InventoryEntity savedInventoryEntity = inventoryRepository.save(inventoryEntity);

        return new InventoryDTO(
                savedInventoryEntity.getSkuId(),
                savedInventoryEntity.getPrimaryStatus().toString(),
                savedInventoryEntity.getPrimaryLocation(),
                savedInventoryEntity.getCostToCompany(),
                savedInventoryEntity.getUpdateDate().toString(),
                savedInventoryEntity.getMiddleMan(),
                savedInventoryEntity.getDealer(),
                savedInventoryEntity.getCreateDate().toString(),
                savedInventoryEntity.getProductType().toString(),
                savedCar.toHashMap()
        );
    }

    public InventoryDTO getInventoryBySKU(String sku) {
        InventoryEntity inventoryEntity = inventoryRepository.findById(sku)
                .orElseThrow(() -> new IllegalArgumentException("Inventory with SKU " + sku + " not found"));
        String productType = inventoryEntity.getProductType().toString();
        String productId = inventoryEntity.getProductId();
        InventoryDTO inventoryDTO = new InventoryDTO();
        util.populateInventoryDTOFromInventoryEntity(inventoryDTO,inventoryEntity);
        HashMap<String, String> productMap = new HashMap<>();
        if(productType.equals("car")) {
            CarEntity car = carRepository.getReferenceById(productId);
            util.populateCarToProductMap(car,productMap);
        }
        inventoryDTO.setProduct(productMap);
        return inventoryDTO;
    }




}
