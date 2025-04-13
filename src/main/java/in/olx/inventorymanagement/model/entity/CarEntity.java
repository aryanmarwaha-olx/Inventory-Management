package in.olx.inventorymanagement.model.entity;

import in.olx.inventorymanagement.model.Interface.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "car")
@Component
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class CarEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long        pid;
    private String      vehicleIdentificationNumber;
    private String      make;
    private String      model;
    private String      trim;
    private String      color;
    private LocalDate   dateOfManufacture;
}
