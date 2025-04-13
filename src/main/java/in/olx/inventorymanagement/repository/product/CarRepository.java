package in.olx.inventorymanagement.repository.product;

import in.olx.inventorymanagement.model.entity.product.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> { }
