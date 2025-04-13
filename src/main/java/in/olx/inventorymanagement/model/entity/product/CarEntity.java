package in.olx.inventorymanagement.model.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CarEntity {
    @Id
    private String      vehicleIdentificationNumber;
    private String      make;
    private String      model;
    private String      trim;
    private String      color;
    private LocalDate   dateOfManufacture;
}
