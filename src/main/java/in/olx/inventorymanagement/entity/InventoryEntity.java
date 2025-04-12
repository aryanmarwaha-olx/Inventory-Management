package in.olx.inventorymanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "inventories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryEntity {
    @Id
    private String SKU;
    private String productType;
    private String productId;
    private LocalDate createDate;
    private String createLocation;
    private LocalDate updateDate;
    private double costPrice;

}
