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

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

@Service
@Component
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
        System.out.println(savedCar);

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
//        System.out.println(inventoryEntity);

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
//        return new InventoryDTO();
    }

    public InventoryDTO getInventoryBySKU(String sku) {
        InventoryEntity inventoryEntity = inventoryRepository.getReferenceById(sku);
        String productType = inventoryEntity.getProductType().toString();
        String productId = inventoryEntity.getProductId();
        InventoryDTO inventoryDTO = new InventoryDTO();
        populateInventoryDTOFromInventoryEntity(inventoryDTO,inventoryEntity);
        HashMap<String, String> productMap = new HashMap<>();
        if(productType.equals("car")) {
            CarEntity car = carRepository.getReferenceById(productId);
            populateCarToProductMap(car,productMap);
        }
        inventoryDTO.setProduct(productMap);
        return inventoryDTO;
    }

    public void populateInventoryDTOFromInventoryEntity(InventoryDTO inventoryDTO, InventoryEntity inventoryEntity) {
        inventoryDTO.setDealer(inventoryEntity.getDealer());
        inventoryDTO.setMiddleMan(inventoryEntity.getMiddleMan());
        inventoryDTO.setPrimaryStatus(inventoryEntity.getPrimaryStatus().toString());
        inventoryDTO.setType(inventoryEntity.getProductType().toString());
        inventoryDTO.setPrimaryLocation(inventoryEntity.getStoreLocation());
        inventoryDTO.setCostToCompany(inventoryEntity.getCostToCompany());
    }

    public void populateCarToProductMap(CarEntity car, HashMap<String, String> productMap) {
        productMap.put("vehicleIdentificationNumber", car.getVehicleIdentificationNumber());
        productMap.put("make", car.getMake());
        productMap.put("model", car.getModel());
        productMap.put("trim", car.getTrim());
        productMap.put("color", car.getColor());
        productMap.put("dateOfManufacture", car.getDateOfManufacture());
    }
}
