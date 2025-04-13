package in.olx.inventorymanagement.repository;

import in.olx.inventorymanagement.model.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    public Optional<LocationEntity> findByAddress(String address);
}