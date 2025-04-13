package in.olx.inventorymanagement.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "inventories")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryEntity {
    public String          productId;
    public String          primaryStatus;
    public String          productType;
    public Integer         costToCompany;
    public String          primaryLocation;                                             // create warehouse.
    public String          updateDate;
    public String          createDate;
    public String          dealer;
    public String          middleMan;

    @Id
    public String          skuId;


    public InventoryEntity(
            String productId,
            String primaryStatus,
            String productType,
            Integer costToCompany,
            String primaryLocation,
            String updateDate,
            String createDate,
            String dealer,
            String middleMan) {

        this.productId = productId;
        this.primaryStatus = primaryStatus;
        this.productType = productType;
        this.costToCompany = costToCompany;
        this.primaryLocation = primaryLocation;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.dealer = dealer;
        this.middleMan = middleMan;
        this.skuId = UUID.randomUUID().toString();
    }
}