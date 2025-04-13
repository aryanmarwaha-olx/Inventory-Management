package in.olx.inventorymanagement.service;

import in.olx.inventorymanagement.model.dto.InventoryDTO;
import in.olx.inventorymanagement.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Page<InventoryDTO> getAllInventoriesWithPagination(int page) {
        return inventoryRepository.findAll(PageRequest.of(page, 10))
                .map(entity -> {
                    InventoryDTO dto = new InventoryDTO();
                    BeanUtils.copyProperties(entity, dto);
                    // Manually map storeLocation to primaryLocation field in DTO
                    dto.setPrimaryLocation(entity.getStoreLocation());
                    return dto;
                });
    }
}


