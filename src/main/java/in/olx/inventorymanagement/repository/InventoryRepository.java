package in.olx.inventorymanagement.repository;

import in.olx.inventorymanagement.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryEntity, String> {
}
