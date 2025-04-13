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
    private Integer         skuId;
    private Integer         productId;
//  private String          productName;        to be placed in product-entity.
    private String          primaryStatus;
    private String          productType;
    private Integer         costToCompany;
    private String          storeLocation;      // create warehouse.
    private LocalDate       updateDate;
    private LocalDate       createDate;
    private Integer         dealerId;
    private String          middleManId;

}
