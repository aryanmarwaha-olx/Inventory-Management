package in.olx.inventorymanagement.model.entity;

import in.olx.inventorymanagement.model.enums.PrimaryStatus;
import in.olx.inventorymanagement.model.enums.ProductType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Table(name = "inventories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class InventoryEntity {
    @Id
    private String          skuId;
    private String          productId;
    private PrimaryStatus   primaryStatus;
    private ProductType     productType;
    private Integer         costToCompany;
    private String          storeLocation;      // create warehouse.
    private LocalDate       updateDate;
    private LocalDate       createDate;
    private String          dealer;
    private String          middleManId;

}