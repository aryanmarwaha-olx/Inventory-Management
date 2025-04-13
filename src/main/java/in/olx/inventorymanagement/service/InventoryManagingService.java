package in.olx.inventorymanagement.service;


import in.olx.inventorymanagement.model.dto.ResponseDTO.InventoryDTO;
import in.olx.inventorymanagement.model.dto.requestDTO.CreateInventoryRequest;

import in.olx.inventorymanagement.model.entity.InventoryEntity;
import in.olx.inventorymanagement.model.entity.product.CarEntity;

import in.olx.inventorymanagement.repository.InventoryRepository;
import in.olx.inventorymanagement.repository.product.CarRepository;

import in.olx.inventorymanagement.utill.Utils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;

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
        InventoryEntity inventoryEntity = inventoryRepository.getReferenceById(sku);
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
