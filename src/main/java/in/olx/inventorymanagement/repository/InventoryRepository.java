package in.olx.inventorymanagement.repository;

import in.olx.inventorymanagement.model.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    public Optional<InventoryEntity> findBySkuId(String skuId);

}