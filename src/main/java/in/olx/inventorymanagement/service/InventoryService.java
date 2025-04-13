package in.olx.inventorymanagement.service;

import in.olx.inventorymanagement.model.dto.InventoryDTO;
import org.springframework.data.domain.Page;

public interface InventoryService {
    Page<InventoryDTO> getAllInventoriesWithPagination(int page);
}
