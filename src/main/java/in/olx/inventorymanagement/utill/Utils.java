package in.olx.inventorymanagement.utill;

import in.olx.inventorymanagement.model.dto.CarInventoryDTO;
import in.olx.inventorymanagement.model.dto.ResponseDTO.InventoryDTO;
import in.olx.inventorymanagement.model.entity.InventoryEntity;
import in.olx.inventorymanagement.model.entity.product.CarEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Utils {
    public void populateInventoryDTOFromInventoryEntity(InventoryDTO inventoryDTO, InventoryEntity inventoryEntity) {
        inventoryDTO.setDealer(inventoryEntity.getDealer());
        inventoryDTO.setMiddleMan(inventoryEntity.getMiddleMan());
        inventoryDTO.setPrimaryStatus(inventoryEntity.getPrimaryStatus().toString());
        inventoryDTO.setType(inventoryEntity.getProductType().toString());
        inventoryDTO.setPrimaryLocation(inventoryEntity.getPrimaryLocation());
        inventoryDTO.setCostToCompany(inventoryEntity.getCostToCompany());
        inventoryDTO.setSkuId(inventoryEntity.getSkuId());
        inventoryDTO.setLastModified(inventoryEntity.getUpdateDate());
    }

    public void populateCarToProductMap(CarEntity car, HashMap<String, String> productMap) {
        productMap.put("vehicleIdentificationNumber", car.getVehicleIdentificationNumber());
        productMap.put("make", car.getMake());
        productMap.put("model", car.getModel());
        productMap.put("trim", car.getTrim());
        productMap.put("color", car.getColor());
        productMap.put("dateOfManufacture", car.getDateOfManufacture());
    }

    public void populateCarInventoryFromInventoryAndCarEntity(CarEntity car, InventoryEntity inventoryEntity, CarInventoryDTO carInventoryDTO) {
        carInventoryDTO.setSku(inventoryEntity.getSkuId());
        carInventoryDTO.setPrimaryStatus(inventoryEntity.getPrimaryStatus());
        carInventoryDTO.setPrimaryLocation(inventoryEntity.getPrimaryLocation());
        carInventoryDTO.setCostToCompany(inventoryEntity.getCostToCompany());
        carInventoryDTO.setCreatedAt(inventoryEntity.getCreateDate());
        carInventoryDTO.setLastModified(inventoryEntity.getUpdateDate());
        carInventoryDTO.setMiddleMan(inventoryEntity.getMiddleMan());
        carInventoryDTO.setDealer(inventoryEntity.getDealer());
        carInventoryDTO.setType(inventoryEntity.getProductType().toString());

        carInventoryDTO.setVin(car.getVehicleIdentificationNumber());
        carInventoryDTO.setMake(car.getMake());
        carInventoryDTO.setModel(car.getModel());
        carInventoryDTO.setTrim(car.getTrim());
        carInventoryDTO.setDateOfManufacture(car.getDateOfManufacture());
    }
}
