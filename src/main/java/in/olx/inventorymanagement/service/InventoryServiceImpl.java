package in.olx.inventorymanagement.service;

import in.olx.inventorymanagement.model.dto.CarInventoryDTO;
import in.olx.inventorymanagement.model.entity.product.CarEntity;
import in.olx.inventorymanagement.repository.InventoryRepository;
import in.olx.inventorymanagement.repository.product.CarRepository;
import in.olx.inventorymanagement.utill.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final CarRepository carRepository;
    private final Utils utils;

    @Override
    public Page<CarInventoryDTO> getAllInventoriesWithPagination(int page) {
        return inventoryRepository.findAll(PageRequest.of(page, 10))
                .map(entity -> {
                    CarInventoryDTO dto = new CarInventoryDTO();
                    String productId = entity.getProductId();
                    CarEntity car = carRepository.getReferenceById(productId);
                    utils.populateCarInventoryFromInventoryAndCarEntity(car, entity, dto);
//                    BeanUtils.copyProperties(entity, dto);
                    // Manually map storeLocation to primaryLocation field in DTO
//                    dto.setPrimaryLocation(entity.getPrimaryLocation());
                    return dto;
                });
    }
}