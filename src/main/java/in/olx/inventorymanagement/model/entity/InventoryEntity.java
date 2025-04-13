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

        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        if (primaryStatus == null || primaryStatus.isEmpty()) {
            throw new IllegalArgumentException("Primary Status cannot be null or empty");
        }
        if (productType == null || productType.isEmpty()) {
            throw new IllegalArgumentException("Product Type cannot be null or empty");
        }
        if (costToCompany == null || costToCompany < 0) {
            throw new IllegalArgumentException("Cost to Company cannot be negative");
        }
        if (primaryLocation == null || primaryLocation.isEmpty()) {
            throw new IllegalArgumentException("Primary Location cannot be null or empty");
        }
        if (updateDate == null || updateDate.isEmpty()) {
            throw new IllegalArgumentException("Update Date cannot be null or empty");
        }
        if (createDate == null || createDate.isEmpty()) {
            throw new IllegalArgumentException("Create Date cannot be null or empty");
        }
        if (dealer == null || dealer.isEmpty()) {
            throw new IllegalArgumentException("Dealer cannot be null or empty");
        }
        if (middleMan == null || middleMan.isEmpty()) {
            throw new IllegalArgumentException("Middle Man cannot be null or empty");
        }

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