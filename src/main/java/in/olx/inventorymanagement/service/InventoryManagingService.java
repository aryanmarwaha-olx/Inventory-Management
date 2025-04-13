package in.olx.inventorymanagement.service;


import in.olx.inventorymanagement.model.dto.ResponseDTO.InventoryDTO;
import in.olx.inventorymanagement.model.dto.requestDTO.CreateInventoryRequest;

import in.olx.inventorymanagement.model.entity.InventoryEntity;
import in.olx.inventorymanagement.model.entity.product.CarEntity;
import in.olx.inventorymanagement.model.enums.PrimaryStatus;
import in.olx.inventorymanagement.model.enums.ProductType;
import in.olx.inventorymanagement.repository.InventoryRepository;
import in.olx.inventorymanagement.repository.LocationRepository;
import in.olx.inventorymanagement.repository.product.CarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;

@Service
public class InventoryManagingService {

    private final InventoryRepository inventoryRepository;
    private final LocationRepository locationRepository;
    private final CarRepository carRepository;

    InventoryManagingService(InventoryRepository inventoryRepository, LocationRepository locationRepository, CarRepository carRepository) {
        this.inventoryRepository = inventoryRepository;
        this.locationRepository = locationRepository;
        this.carRepository = carRepository;
    }


    public InventoryDTO createInventory(CreateInventoryRequest requestDTO) {
        // database product - insert i.e car
        HashMap<String, String> productMap = requestDTO.getProduct();

        // code clean up required.

        CarEntity car = new CarEntity();
        CarEntity savedCar = new CarEntity();
        ProductType productType = ProductType.CAR;
        if (requestDTO.type.equals("car")) {
            car = new CarEntity(productMap.get("vehicleIdentificationNumber"), productMap.get("make"), productMap.get("model"), productMap.get("trim"), productMap.get("color"), productMap.get("dateOfManufacture"));
            savedCar = carRepository.save(car);
            productType = ProductType.CAR;
        }

        // Create a new InventoryEntity Object and save it.
        // Inflate InventoryDTO object.
        return new InventoryDTO();
    }
}
