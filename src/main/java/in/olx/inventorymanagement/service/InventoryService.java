package in.olx.inventorymanagement.service;

import in.olx.inventorymanagement.model.dto.CarInventoryDTO;
import org.springframework.data.domain.Page;

public interface InventoryService {
    Page<CarInventoryDTO> getAllInventoriesWithPagination(int page);
}
