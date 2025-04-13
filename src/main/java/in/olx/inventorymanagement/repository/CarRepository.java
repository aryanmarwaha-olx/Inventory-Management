package in.olx.inventorymanagement.repository;

import in.olx.inventorymanagement.model.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    Optional<CarEntity> findByVehicleIdentificationNumber(String vehicleIdentificationNumber);

}
