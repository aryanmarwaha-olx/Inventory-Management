package in.olx.inventorymanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {
    @Id
    private Long pid;
    private String vehicleIdentificationNumber;
    private String make;
    private String model;
    private String trim;
    private String color;
    private LocalDate dateOfManufacture;
}
