package in.olx.inventorymanagement.model.entity;

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
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Component
public class InventoryEntity {
    @Id
    private Long            skuId;
    private Long            productId;
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