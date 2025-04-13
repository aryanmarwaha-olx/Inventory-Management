package in.olx.inventorymanagement.model.entity;

import in.olx.inventorymanagement.model.enums.PrimaryStatus;
import in.olx.inventorymanagement.model.enums.ProductType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "inventories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryEntity {
    @Id
    private String          skuId              =  UUID.randomUUID().toString();
    private String          productId;
    private PrimaryStatus   primaryStatus;
    private ProductType     productType;
    private Integer         costToCompany;
    private String          storeLocation;                                             // create warehouse.

    @LastModifiedDate
    private LocalDate       updateDate;

    @CreatedDate
    private LocalDate       createDate;

    private String          dealer;

    @CreatedBy
    private String          middleMan;
}