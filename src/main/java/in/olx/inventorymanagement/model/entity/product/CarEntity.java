package in.olx.inventorymanagement.model.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

@Entity
@Table(name = "car")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {
    public String      make;
    public String      model;
    public String      trim;
    public String      color;
    public String      dateOfManufacture;

    @Id
    public String      vehicleIdentificationNumber;

    public CarEntity(String make, String model, String trim, String color, String dateOfManufacture) {
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.color = color;
        this.dateOfManufacture = dateOfManufacture;

        vehicleIdentificationNumber = UUID.randomUUID().toString();
    }

    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("vehicleIdentificationNumber", vehicleIdentificationNumber);
        map.put("make", make);
        map.put("model", model);
        map.put("trim", trim);
        map.put("color", color);
        map.put("dateOfManufacture", dateOfManufacture);
        return map;
    }
}
